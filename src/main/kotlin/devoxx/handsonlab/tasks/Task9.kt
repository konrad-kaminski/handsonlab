package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Implement [sendMessageInNamedCoroutine] function, which should start a new coroutine in [GlobalScope].
 * The [CoroutineContext] used should include [CoroutineName] context with the specified [coroutineName].
 * The coroutine should call [sendCoroutineNameMessage] function.
 */
fun sendMessageInNamedCoroutine(coroutineName: String): Unit {
    GlobalScope.launch(CoroutineName(coroutineName)) {
        sendCoroutineNameMessage()
    }
}

/**
 * Implement [sendCoroutineNameMessage] function, which should [sendMessage] with the name of the coroutine
 * (from [CoroutineName]) as an argument.
 */
suspend fun CoroutineScope.sendCoroutineNameMessage() =
    sendMessage(coroutineContext[CoroutineName]!!.name)
