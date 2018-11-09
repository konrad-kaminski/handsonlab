package devoxx.handsonlab.tasks

import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

/**
 * Implement [separateThreadReturn] function, which should create and start new thread and then suspend. The thread name
 * should be [threadName] and it should sleep for 2 seconds and then resume [separateThreadReturn] so that it returns [msg]
 * as a result. Use [suspendCoroutine].
 */
suspend fun separateThreadReturn(threadName: String, msg: String): String = TODO()

/**
 * Implement [separateThreadReturn]2 function, which should [delay] for 2 seconds and then create and start new thread
 * and then suspend. The thread name should be [threadName] and it should resume [separateThreadReturn2] so that it returns [msg]
 * as a result. Use [suspendCoroutine].
 *
 * Can you tell the difference between this function and the [separateThreadReturn] function?
 */
suspend fun separateThreadReturn2(threadName: String, msg: String): String = TODO()