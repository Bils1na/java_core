package org.example.hw3;

import java.util.Comparator;
import java.util.Iterator;

public abstract class BaseWorker
        implements Comparable<BaseWorker> {

    protected String firstName;
    protected String lastName;
    protected int salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }


    public BaseWorker() {
        firstName = "firstName";
        lastName = "lastName";
    }

    private BaseWorker(String name) {
        this(name, "lastName");
    }

    protected BaseWorker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected abstract void setSalary();

    @Override
    public int compareTo(BaseWorker anotherWorker) {
        if (getSalary() == anotherWorker.getSalary()) {
            return 0;
        } else if (getSalary() < anotherWorker.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s - %d", getFirstName(), getLastName(), getSalary());
    }

}
