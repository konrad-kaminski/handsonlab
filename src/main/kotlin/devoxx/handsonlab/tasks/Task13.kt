package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageCPUConsumingWithCancel] function, which should start a coroutine using scope from [runBlocking] and
 * [Dispatchers.Default] as a context.
 * The coroutine should spin loop for 2 seconds and the [sendMessage] [msg].
 * The [Job] of a coroutine should be cancelled immediately after its creation.
 *
 * Compare this function with [sendMessageWithCancel]. What differences do you see?
 */
fun sendMessageCPUConsumingWithCancel(msg: String): Unit = TODO()