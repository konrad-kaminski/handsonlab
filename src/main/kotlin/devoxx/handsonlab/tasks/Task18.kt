package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageWithAsync] function, which should create and start a coroutine in [GlobalScope].
 * The coroutine should [sendMessage] [msg] and return "sent: ZZZ", where ZZZ is [msg].
 * The result of the coroutine should be returned as [Deferred].
 */
fun sendMessageWithAsync(msg: String): Deferred<String> = TODO()