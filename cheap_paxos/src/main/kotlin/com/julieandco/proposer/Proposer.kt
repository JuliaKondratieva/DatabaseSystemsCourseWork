package com.julieandco.proposer

interface Proposer {
    suspend fun propose(proposeRequest: ProposerRequest): ProposerResponse
}