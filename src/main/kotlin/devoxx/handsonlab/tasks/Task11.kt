package devoxx.handsonlab.tasks

import kotlinx.coroutines.*

/**
 * Implement [sendMessageWithGlobalScopeCancel] function, which should start a coroutine using [GlobalScope].
 * The coroutine should [delay] for 2 seconds and then [sendMessage] [msg].
 * The [Job] of a coroutine should be cancelled immediately after its creation and then [sendMessageWithGlobalScopeCancel] should
 * wait (hint: joined) for the coroutine to be finished.
 *
 * What is the expected result? Is there a race condition here?
 */
fun sendMessageWithGlobalScopeCancel(msg: String): Unit = TODO()