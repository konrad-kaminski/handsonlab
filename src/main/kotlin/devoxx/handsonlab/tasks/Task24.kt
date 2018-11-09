package devoxx.handsonlab.tasks

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


/**
 * Implement [createCounter] function, which should create an object which implements [Counter] interface.
 * You should use [Mutex] in your [Counter] implementation
 */
fun createCounter(initialValue: Int): Counter = TODO()

interface Counter {
    suspend fun inc()

    suspend fun current(): Int
}
