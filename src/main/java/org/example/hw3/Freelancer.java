package org.example.hw3;

public class Freelancer extends BaseWorker {

    protected int salaryPerHour;

    public Freelancer(String firstName, String lastName, int salaryPerHour) {
        super(firstName, lastName);
        this.salaryPerHour = salaryPerHour;
        setSalary();
    }

    @Override
    protected void setSalary() {
        salary = (int) (20.8 * 8 * salaryPerHour);
    }
}
