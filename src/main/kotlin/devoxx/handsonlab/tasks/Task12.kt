package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageWithCancel] function, which should start a coroutine using scope from [runBlocking] and
 * [Dispatchers.Default] as a context.
 * The coroutine should [sendMessage] [msg] and then [delay] for 2 seconds.
 * The [Job] of a coroutine should be cancelled immediately after its creation.
 *
 * What is the expected result? Is there a race condition here?
 */
fun sendMessageWithCancel(msg: String) {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            sendMessage(msg)
            delay(2_000)
        }
        job.cancel()
    }
}
