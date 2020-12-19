package com.julieandco
import com.julieandco.acceptor.AcceptorImpl
import com.julieandco.learner.LearnerImpl
import com.julieandco.proposer.ProposerRequest
import com.julieandco.proposer.ProposerImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() = runBlocking {
    val proposers = (0 until 5).map { ProposerImpl(it) }.toList()
    val acceptors = (0 until 3).map { AcceptorImpl() }.toList()
    val learners = (0 until 3).map { LearnerImpl() }.toList()
    proposers.forEach { it.acceptors.addAll(acceptors) }
    proposers.forEach { it.learners.addAll(learners) }

    proposers.map {
        GlobalScope.launch {
            val result = it.propose(ProposerRequest(Random.nextInt()))
            println("Proposer: ${result.value}")
        }
    }.forEach { it.join() }

    learners.forEach { println("Learner: ${it.decidedValue}") }
}

