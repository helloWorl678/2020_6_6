package com.linyuanhang.main.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class Mythread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }
}

public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Mythread());
        new Thread(futureTask, "A").start();
        String result = futureTask.get();
        System.out.println(result);


    }
}
