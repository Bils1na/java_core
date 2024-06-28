package org.example.jdk_sem5.task1;
//В рамках выполнения задачи необходимо:
//Создать два класс ObjectA, ObjectB
//Реализовать класс в котором два потока при запуске провоцируют DeadLock для объектов ObjectA, ObjectB
public class Program {

    public static void main(String[] args) {
//        Object objectA = new Object();
//        Object objectB = new Object();
//
//        Thread threadA = new Thread(() -> {
//            synchronized (objectA) {
//                System.out.println("ThreadA");
//                synchronized (objectB) {
//                    System.out.println("ThreadB_");
//                }
//            }
//        });
//
//        Thread threadB = new Thread(() -> {
//            synchronized (objectB) {
//                System.out.println("ThreadB");
//                synchronized (objectA) {
//                    System.out.println("ThreadA_");
//                }
//            }
//        });
//
//        threadA.start();
//        threadB.start();
        Friend friend1 = new Friend("Вася");
        Friend friend2 = new Friend("Петя");

        MyThread thread1 = new MyThread(friend1, friend2);
        MyThread thread2 = new MyThread(friend2, friend1);

        thread1.start();
        thread2.start();

        System.out.println("конец работы");
    }

}
