package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

val requestId = ThreadLocal<String>()

/**
 * Implement [sendMessageWithRequestId] function, which should call [sendMessageUsingDispatcherDefault] [msg].
 * Be aware that [sendMessageUsingDispatcherDefault] will use different thread to execute [sendMessage] as it
 * uses [Dispatchers.Default] context.
 *
 * Hint: use [asContextElement]
 */
suspend fun sendMessageWithRequestId(msg: String): Unit = TODO()

suspend fun sendMessageUsingDispatcherDefault (msg: String) = withContext(Dispatchers.Default) {
    sendMessage("${requestId.get()}: $msg")
}

