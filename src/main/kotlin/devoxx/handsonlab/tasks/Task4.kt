package devoxx.handsonlab.tasks

import kotlinx.coroutines.*
import java.lang.Thread.sleep

/**
 * Implement [sendMultipleWithSleep] function, which should start [n] coroutines in [GlobalScope].
 * Each coroutine should [sleep] for 2 seconds and then call [sendMessage] with [msg] parameter.
 * Wait for all the coroutine to finish using [joinAll].
 */
fun sendMultipleWithSleep(n: Long, msg: String): Unit = TODO()

/**
 * Implement [sendMultipleWithSleep] function. It should start [n] coroutines in [GlobalScope].
 * Each coroutine should [delay] for 2 seconds and then call [sendMessage] with [msg] parameter.
 * Wait for all the coroutine to finish using [joinAll].
 *
 * Can you tell the difference between this function and [sendMultipleWithSleep]?
 */
fun sendMultipleWithDelay(n: Long, msg: String): Unit = TODO()

/**
 * Bonus task: increase the time from 2 seconds to 60 seconds. Execute the tests in both cases and use
 * thread dump to check the number of threads running concurrently during sleep/delay.
 */
