package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessagesWithAsync] function, which should create and start two coroutines with [Dispatchers.Default] context.
 * Each coroutine should [delay] for 2 seconds, [sendMessageAck] [msg1] and [msg2] respectively
 * and return the results of [sendMessageAck] as a [Pair].
 * Do not use [GlobalScope]. Do not use [runBlocking].
 */
suspend fun sendMessagesWithAsync(msg1: String, msg2: String): Pair<String, String> = TODO()