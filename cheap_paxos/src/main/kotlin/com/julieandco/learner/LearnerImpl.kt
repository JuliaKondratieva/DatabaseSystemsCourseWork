package com.julieandco.learner

class LearnerImpl: Learner {
    var decidedValue: Int? = null
    override suspend fun decide(decideRequest: DecideRequest) {
        decidedValue = decideRequest.value
    }
}