package com;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl=new CountDownLatch(3);
        new Work(cdl);
        new Work(cdl);
        new Work(cdl);

        cdl.await();
        System.out.println("all jobs done ");
    }
}
class Work extends Thread{
    CountDownLatch cdl;

    public Work(CountDownLatch cdl) {
        this.cdl = cdl;
        start();
    }

    @Override
    public void run(){
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done work");
        cdl.countDown();
    }
}