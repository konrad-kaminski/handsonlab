package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch


/**
 * Implement [sendFromMultipleCoroutines] function, which should start [n] coroutines.
 * Each coroutine should send its number (1..n) to the [channel].
 */
fun CoroutineScope.sendFromMultipleCoroutines(n: Int, channel: SendChannel<Int>): Unit = TODO()