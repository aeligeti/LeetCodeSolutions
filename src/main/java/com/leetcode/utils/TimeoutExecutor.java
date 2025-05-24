package com.leetcode.utils;

import java.util.concurrent.*;

public class TimeoutExecutor {
    public static <T> T executeWithTimeout(Callable<T> task, long timeoutMs, String taskName) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<T> future = executor.submit(task);
        try {
            return future.get(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new TimeoutException("Task '" + taskName + "' exceeded timeout of " + timeoutMs + "ms");
        } finally {
            executor.shutdownNow();
        }
    }
}