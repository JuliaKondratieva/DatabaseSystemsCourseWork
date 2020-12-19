package com.julieandco.acceptor

sealed class AcceptorResponse {
    object Accept: AcceptorResponse()
    object Reject: AcceptorResponse()
}