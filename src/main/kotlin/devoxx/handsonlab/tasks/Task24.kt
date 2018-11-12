package devoxx.handsonlab.tasks

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


/**
 * Implement [createCounter] function, which should create an object which implements [Counter] interface.
 * You should use [Mutex] in your [Counter] implementation
 */
fun createCounter(initialValue: Int): Counter =
    object: Counter {
        private var value = initialValue
        private val mutex = Mutex()

        override suspend fun inc() {
            mutex.withLock {
                value++
            }
        }

        override suspend fun current(): Int =
            mutex.withLock {
                value
            }
    }

interface Counter {
    suspend fun inc()

    suspend fun current(): Int
}
