package com.et;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;
import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AwaitilityExampleTest {

    @Test
    public void testAsyncFlag() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();

        // Use Awaitility to wait until the flag becomes true
        Awaitility.await()
                .atMost(5, SECONDS)
                .until(example::isFlag);
        System.out.println("ssss");
        // Verify that the flag is true
        assertTrue(example.isFlag(), "Flag should be true after async task completes");
    }

    @Test
    public void testAsynchronousNormal() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();
        try {
            // Default timeout is 10 seconds. If the condition is not met within this period, a ConditionTimeoutException is thrown
            Awaitility.await().until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return example.isFlag();
                }
            });
        } catch (Exception e) {
            Assertions.fail("Run exception: " + e.getMessage() + ", error: " + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousAtMost() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();
        try {
            // Specify a timeout of 3 seconds. If the condition is not met within this period, a ConditionTimeoutException is thrown
            Awaitility.await().atMost(3, SECONDS).until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return example.isFlag();
                }
            });
        } catch (Exception e) {
            Assertions.fail("Run exception: " + e.getMessage() + ", error: " + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousAtLeast() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();

        try {
            // Specify at least 1 second and at most 3 seconds. If the condition is not met within this period, a ConditionTimeoutException is thrown
            Awaitility.await().atLeast(1, SECONDS).and().atMost(3, SECONDS).until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return example.isFlag();
                }
            });

        } catch (Exception e) {
            Assertions.fail("Run exception: " + e.getMessage() + ", error: " + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousPoll() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();
        try {
            // Polling query, pollInterval specifies how often to poll, pollDelay specifies the delay between each poll
            Awaitility.with().pollInterval(ONE_HUNDRED_MILLISECONDS).and().with().pollDelay(50, MILLISECONDS).await("count is greater 3").until(
                    new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return example.isFlag();
                        }
                    });
        } catch (Exception e) {
            Assertions.fail("Run exception: " + e.getMessage() + ", error: " + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousFibonacciPoll() {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();
        try {
            // Use Fibonacci numbers as the interval: 1, 1, 2, 3, 5, 8,..., default unit is milliseconds
            Awaitility.with().pollInterval(fibonacci(SECONDS)).await("count is greater 3").until(
                    new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return example.isFlag();
                        }
                    });
        } catch (Exception e) {
            Assertions.fail("Run exception: " + e.getMessage() + ", error: " + e.getStackTrace()[0].toString());
        }
    }
}