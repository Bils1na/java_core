package org.example.jdk_hw5;

public class Dining {
    private final int numberOfPhilosophers;
    private final Philosopher[] philosophers;
    private final Fork[] forks;

    public Dining(int numberOfPhilosophers) {
        this.numberOfPhilosophers = numberOfPhilosophers;
        philosophers = new Philosopher[numberOfPhilosophers];
        forks = new Fork[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];

            philosophers[i] = new Philosopher(i, leftFork, rightFork);
        }
    }

    public void startDinner() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    public void waitForDinnerToEnd() {
        for (Philosopher philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
