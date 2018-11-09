package devoxx.handsonlab.tasks

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
  Implement [sendDelayedUsingJobJoin] function, which should do the same thing as [blockingSendDelayedMessage], but since it's a
  suspending function you're allowed to use [Job.join].
 */
suspend fun sendDelayedUsingJobJoin(msg: String): Unit = TODO()