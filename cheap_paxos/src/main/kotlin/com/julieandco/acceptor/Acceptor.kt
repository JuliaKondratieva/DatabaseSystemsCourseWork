package com.julieandco.acceptor
import com.julieandco.acceptor.AcceptorRequest.*

interface Acceptor {
    suspend fun prepare(prepareRequest: PrepareRequest): PrepareResponse
    suspend fun accept(acceptRequest: AcceptRequest): AcceptorResponse
}