package devoxx.handsonlab.tasks

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Implement [suspendingSendMessagesWithTwoCoroutines] function, which should do the same thing as [sendMessagesWithTwoCoroutines],
 * but since it's a suspending function it should not use [runBlocking]
 */
suspend fun suspendingSendMessagesWithTwoCoroutines(msg1: String, msg2: String): Unit = TODO()