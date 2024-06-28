package org.example.jdk_sem5.task3;

import java.util.concurrent.CountDownLatch;

//В рамках выполнения задачи необходимо:
//        3 бегуна должны прийти к старту гонки
//Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
//Программа должна отсчитать “На старт”, “Внимание”, “Марш”
//Программа должна завершиться когда все участники закончат гонку.
//Подумайте об использовании примитива синхронизации
public class Program {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Runner runner1 = new Runner("Vasya", countDownLatch);
        Runner runner2 = new Runner("Petya", countDownLatch);
        Runner runner3 = new Runner("Vanya", countDownLatch);

        runner1.start();
        runner2.start();
        runner3.start();

        while (countDownLatch.getCount() != 1) {
            Thread.sleep(100);
        }
        gogogo();
        countDownLatch.countDown();

//        runner1.join();
//        runner2.join();
//        runner3.join();

        // награждение
    }

    static void gogogo() throws InterruptedException {
        System.out.println("На старт!");
        Thread.sleep(100);
        System.out.println("Внимание!");
        Thread.sleep(100);
        System.out.println("Марш!");

    }
}
