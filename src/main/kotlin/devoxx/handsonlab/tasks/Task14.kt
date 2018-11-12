package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageWithTimeout] function, which should call [slowSendMessage], but wait only up to 1 second
 * for it to be finished and throw [TimeoutCancellationException] if [slowSendMessage] could not finish its execution
 * in this timeframe.
 */
suspend fun sendMessageWithTimeout(msg: String) {
    withTimeout(1_000) {
        slowSendMessage(msg)
    }
}

/**
 * Implement [slowSendMessage] function, which should [delay] for 2 seconds and then [sendMessage] [msg].
 */
suspend fun slowSendMessage(msg: String): Unit {
    delay(2_000)
    sendMessage(msg)
}
