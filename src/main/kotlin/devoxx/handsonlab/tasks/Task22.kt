package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.filter
import kotlinx.coroutines.channels.produce


/**
 * Implement [produceNumbers] function, which should create a new channel (returned as a result)
 * and send to it integers from [min] to [max].
 */
fun CoroutineScope.produceNumbers(min: Int, max: Int): ReceiveChannel<Int> = TODO()

/**
 * Implement [filterNumbers] function, which should filter the [input] channel and produce an
 * output channel as a result. The output channel should only emit even integers from [input].
 */
fun CoroutineScope.filterNumbers(input: ReceiveChannel<Int>): ReceiveChannel<Int> = TODO()

/**
 * Implement [mapNumbersToStrings] function, which should read the values from the [input] channel
 * and produce an output channel as a result. The output channel should emit integers from [input] converted to [String].
 */
fun CoroutineScope.mapNumbersToStrings(input: ReceiveChannel<Int>): ReceiveChannel<String> = TODO()