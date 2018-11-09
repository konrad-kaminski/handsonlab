package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

/**
 * Implement [sendMessageInNewThreadContext] function, which should start a new coroutine in [GlobalScope].
 * The context used should use new [CoroutineDispatcher] with a threadpool with a single thread
 * (you can use [newSingleThreadContext] for that) with a [threadName] name in it. The context should also include
 * the name of the coroutine ([coroutineName]) as [CoroutineName] context. The coroutine
 * should [sendMessage] with [msg] as a parameter.
 */
fun sendMessageInNewThreadContext(coroutineName: String, threadName: String, msg: String): Unit = TODO()