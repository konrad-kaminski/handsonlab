package devoxx.handsonlab.tasks

interface SuspendingInterface {
    suspend fun execute(p: Int): Int
}