package com.julieandco.acceptor

import com.julieandco.ProposalNumber
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import com.julieandco.acceptor.PrepareResponse.*

class AcceptorImpl: Acceptor {
    private var acceptedResponse: Int? = null
    private var currentProposalNumber: ProposalNumber? = null
    private val acceptorMutex = Mutex()
    override suspend fun prepare(prepareRequest: AcceptorRequest.PrepareRequest): PrepareResponse {
        return acceptorMutex.withLock {
            if (currentProposalNumber == null || prepareRequest.proposalNumber > currentProposalNumber) {
                if (acceptedResponse == null) {
                    currentProposalNumber = prepareRequest.proposalNumber
                    PromisePrepare
                } else {
                    PromiseAccepted(currentProposalNumber!!, acceptedResponse!!)
                }
            } else {
                Reject(currentProposalNumber!!)
            }
        }
    }

    override suspend fun accept(acceptRequest: AcceptorRequest.AcceptRequest): AcceptorResponse {
        return acceptorMutex.withLock<AcceptorResponse> {
            return if (acceptRequest.proposalNumber >= currentProposalNumber) {
                currentProposalNumber = acceptRequest.proposalNumber
                acceptedResponse = acceptRequest.value
                AcceptorResponse.Accept
            } else {
                AcceptorResponse.Reject
            }
        }
    }
}