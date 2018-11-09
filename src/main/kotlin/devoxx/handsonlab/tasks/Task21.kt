package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

/**
 * Implement [produceMessageToChannel] function, which should create a new channel and
 * send a [msg] to it. Use [produce] with [Dispatchers.Default] coroutine context.
 */
fun CoroutineScope.produceMessageToChannel(msg: String): ReceiveChannel<String> = TODO()