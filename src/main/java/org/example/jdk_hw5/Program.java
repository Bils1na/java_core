package org.example.jdk_hw5;

public class Program {
    public static void main(String[] args) {
        Dining diningPhilosophers = new Dining(5);
        diningPhilosophers.startDinner();
        diningPhilosophers.waitForDinnerToEnd();
    }
}
