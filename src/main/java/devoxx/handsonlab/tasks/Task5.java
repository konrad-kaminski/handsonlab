package devoxx.handsonlab.tasks;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;

/**
 * Provide {@link SuspendingInterface} implementation which delegates calls to the
 * <i>delegate</i> passed as constructor parameter. The return value from the delegate should be
 * increased by 5.
 *
 * Using {@link IntrinsicsKt#getCOROUTINE_SUSPENDED()} ] might come handy.
 *
 * Try adding some logging statements to observe what are the results of the <i>execute</i> method.
 */
public class Task5 implements SuspendingInterface {
    public Task5(final SuspendingInterface delegate) {
    }

    @Override
    public Object execute(int p, @NotNull Continuation<? super Integer> continuation) {
        return null;
    }
}
