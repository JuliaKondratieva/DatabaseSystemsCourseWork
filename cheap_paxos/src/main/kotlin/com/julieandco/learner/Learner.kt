package com.julieandco.learner

interface Learner {
    suspend fun decide(decideRequest: DecideRequest)
}