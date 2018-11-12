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
    private final SuspendingInterface delegate;

    public Task5(final SuspendingInterface delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object execute(int p, @NotNull Continuation<? super Integer> continuation) {
        final Object result = delegate.execute(p, new Continuation<Integer>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return continuation.getContext();
            }

            @Override
            public void resumeWith(@NotNull Object o) {
                continuation.resumeWith (((Integer) o) + 5);
            }
        });

        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        } else {
            return ((Integer) delegate.execute(p, continuation)) + 5;
        }
    }
}
