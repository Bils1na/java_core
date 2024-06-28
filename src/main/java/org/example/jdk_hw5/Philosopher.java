package org.example.jdk_hw5;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep(((int) (Math.random() * 100)));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                think();
                while (true) {
                    if (leftFork.pickUp()) {
                        try {
                            if (rightFork.pickUp()) {
                                try {
                                    eat();
                                    break;
                                } finally {
                                    rightFork.putDown();
                                }
                            }
                        } finally {
                            leftFork.putDown();
                        }
                    }
                    Thread.sleep(((int) (Math.random() * 10)));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
