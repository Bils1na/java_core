package org.example.jdk_hw4;

public class Employee {

    private static int nextId = 1;
    private int id;
    private String phone;
    private String name;
    private int experience;


    public Employee(String phone, String name, int experience) {
        id = nextId++;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("%d: Имя: %s, Телефон: %s, Опыт: %d",
                getId(), getName(), getPhone(), getExperience());
    }
}
