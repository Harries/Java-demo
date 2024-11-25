package com.et;

import org.awaitility.Awaitility;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AwaitilityExample {
    private volatile boolean flag = false;

    public void startAsyncTask() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                // mock async
                Thread.sleep(5000);
                flag = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executor.shutdown();
    }

    public boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) {
        AwaitilityExample example = new AwaitilityExample();
        example.startAsyncTask();

        // use Awaitility to wait flag for true
        Awaitility.await()
                  .atMost(5, TimeUnit.SECONDS)
                  .until(example::isFlag);

        System.out.println("Flag is now true!");
    }
}