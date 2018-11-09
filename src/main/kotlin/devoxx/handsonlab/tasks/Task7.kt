package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessagesWithTwoCoroutines] function, which should start two coroutines using scope
 * from [runBlocking]. One of the coroutines should [delay] for 2 seconds and then [sendMessage] [msg1].
 * The second coroutine should just [sendMessage] [msg2].
 *
 * Try changing the sequence of coroutines startup and see how it affects the function.
 */
fun sendMessagesWithTwoCoroutines(msg1: String, msg2: String): Unit = TODO()