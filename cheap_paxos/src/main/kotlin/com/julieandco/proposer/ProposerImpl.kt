package com.julieandco.proposer

import com.julieandco.ProposalNumber
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import com.julieandco.acceptor.AcceptorRequest.*
import com.julieandco.acceptor.PrepareResponse.*
import com.julieandco.acceptor.AcceptorResponse
import com.julieandco.acceptor.Acceptor
import com.julieandco.learner.DecideRequest
import com.julieandco.learner.Learner
import java.nio.charset.StandardCharsets
import kotlin.math.floor

class ProposerImpl(private val proposerId: Int, val acceptorssize:Int): Proposer {
    val acceptors = mutableListOf<Acceptor>()
    val learners = mutableListOf<Learner>()
    private val consensus get() = (floor(acceptorssize / 2f) + 1).toInt()

    private val proposerMutex = Mutex()
    private var roundCount = 0
    override suspend fun propose(proposeRequest: ProposerRequest): ProposerResponse {

        proposerMutex.withLock {
                while (!Thread.currentThread().isInterrupted) {
                    roundCount++
                    val roundIdentifier = ProposalNumber(roundCount, proposerId)

                    // Phase 1: Prepare
                    val prepareResponses = acceptors.map {
                        it.prepare(
                            PrepareRequest(roundIdentifier)
                        )
                    }.toList()
                    val roundHighMark = prepareResponses
                        .filter { it is Reject }.map { it as Reject }
                        .maxBy { it.proposalNumber }
                        ?.proposalNumber?.round
                    if (roundHighMark != null) {
                        roundCount = roundHighMark
                        continue
                    }
                    val acceptedValue = prepareResponses
                        .filter { it is PromiseAccepted }.map { it as PromiseAccepted }
                        .maxBy { it.proposalNumber }
                        ?.value ?: proposeRequest.value

                    // Phase 2: Accept
                    val agreedNodes = acceptors
                        .map { it.accept(AcceptRequest(roundIdentifier, acceptedValue)) }
                        .filter { it is AcceptorResponse.Accept }
                        .size
                    if (agreedNodes >= consensus) {
                        learners.forEach { it.decide(DecideRequest(acceptedValue)) }
                        return ProposerResponse(acceptedValue)
                    }
                }

                throw InterruptedException()
            }
        }
    }

