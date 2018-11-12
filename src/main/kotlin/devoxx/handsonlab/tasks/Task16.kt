package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageWithAllChildrenCancel] function, which should start two coroutines. The first coroutine
 * should [delay] for 5 seconds and the [sendMessage] [msg1].
 * The second coroutine should [delay] for 1 second and then cancel all children of the parent [Job].
 * Do not use [GlobalScope].
 */
suspend fun sendMessageWithAllChildrenCancel(msg: String): Unit {
    coroutineScope {
        val parent = coroutineContext[Job]!!
        launch(Dispatchers.Default) {
            delay(5_000)
            sendMessage(msg)
        }
        launch(Dispatchers.Default) {
            delay(1_000)
            parent.cancelChildren()
        }
    }
}
