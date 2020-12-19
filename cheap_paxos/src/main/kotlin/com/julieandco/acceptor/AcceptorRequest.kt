package com.julieandco.acceptor

import com.julieandco.ProposalNumber

sealed class AcceptorRequest {
    data class PrepareRequest(val proposalNumber: ProposalNumber): AcceptorRequest()
    data class AcceptRequest(val proposalNumber: ProposalNumber, val value: Int): AcceptorRequest()
}