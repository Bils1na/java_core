package org.example.hw3;

import java.util.Random;

public class Worker extends BaseWorker {

    protected String position;
    private Random bonus = new Random();

    public String getPosition() {
        return position;
    }


    public Worker(String firstName, String lastName, String position) {
        super(firstName, lastName);
        this.position = position;
        setSalary();
    }

    @Override
    protected void setSalary() {
        switch (this.position) {
            case "Босс" -> salary = 100000 + bonus.nextInt(1000, 2000);
            case "Менеджер" -> salary = 70000 + bonus.nextInt(1000, 2000);
            case "Работник" -> salary = 45000 + bonus.nextInt(1000, 2000);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s - %d", getFirstName(), getLastName(), getPosition(), getSalary());
    }

}
