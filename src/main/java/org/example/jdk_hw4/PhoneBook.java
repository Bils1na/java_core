package org.example.jdk_hw4;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    ArrayList<Employee> phoneBook;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
    }

    public List<Employee> orderByExperience(int exp) {
        return phoneBook.stream().filter(o -> o.getExperience() == exp).toList();
    }

    public String getPhoneByName(String name) {
        return phoneBook.stream().filter(o -> o.getName().equals(name)).toList().get(0).getPhone();
    }

    public String orderById(int id) {
        return phoneBook.stream().filter(o -> o.getId() == id).toList().get(0).toString();
    }

    public void add(Employee employee) {
        phoneBook.add(employee);
    }

}
