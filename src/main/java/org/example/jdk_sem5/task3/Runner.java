package org.example.jdk_sem5.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread {
    private String name;
    private static Random random = new Random();
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();
            goToFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToStart() throws InterruptedException {
        System.out.println(name + " движется к линии старта");
        sleep(random.nextLong(1000, 3000));
        System.out.println(name + " пришел на линию старта");
        cdl.countDown();
    }

    public void goToFinish() throws InterruptedException {
        System.out.println(name + " бежит к линии финиша");
        sleep(random.nextLong(1000, 3000));
        System.out.println(name + " финишировал");
    }
}
