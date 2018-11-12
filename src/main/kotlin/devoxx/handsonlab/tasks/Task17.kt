package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Implement [sendMessagesWithExceptionHandler] function, which should start a coroutine
 * in [GlobalScope]. The coroutine should [sendMessage] [msg]. There should be an exception handler
 * attached to the coroutine (in the form of [CoroutineExceptionHandler]), which should delegate
 * exception handling to the [onException] handler.
 */
fun sendMessagesWithExceptionHandler(msg: String, onException: (Throwable) -> Unit) {
    val handler = CoroutineExceptionHandler { _, ex ->
        onException(ex)
    }
    GlobalScope.launch(handler) {
        sendMessage(msg)
    }
}
