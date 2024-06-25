package org.example.jdk_hw4;

public class Program {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        Employee employee = new Employee("123", "Artemiy", 3);
        Employee employee2 = new Employee("1233", "Anastasiya",1);
        Employee employee3 = new Employee("123424", "Yamilya", 5);
        Employee employee4 = new Employee("12356", "Vitaliy", 2);
        Employee employee5 = new Employee("1212", "Igor", 3);

        phoneBook.add(employee);
        phoneBook.add(employee2);
        phoneBook.add(employee3);
        phoneBook.add(employee4);
        phoneBook.add(employee5);

        System.out.println(phoneBook.getPhoneByName("Artemiy"));
        System.out.println(phoneBook.orderById(2));
        System.out.println(phoneBook.orderByExperience(3));
    }

}
