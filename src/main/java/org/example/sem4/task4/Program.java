package org.example.sem4.task4;

import org.example.sem4.task4.exceptions.AmountException;
import org.example.sem4.task4.exceptions.CustomerException;
import org.example.sem4.task4.exceptions.ProductException;

public class Program {

    public static void main(String[] args) {
        Object[][] info = {
                {Shop.getCustomers()[0], Shop.getItems()[0], 2}, //good
                {Shop.getCustomers()[1], Shop.getItems()[1], -1}, //bad amount -1
                {Shop.getCustomers()[0], Shop.getItems()[2], 150}, //bad amount > 100
                {Shop.getCustomers()[1], new Item("Цветок", 10), 1}, //no item
                {new Customer("Федор", 40, "+3-222-333-44-55"), Shop.getItems()[3], 1}, //no customer
        };
        int capacity = 0;
        int i = 0;
        while (capacity != Shop.getOrders().length - 1 || i != info.length) {
            try {
                Shop.getOrders()[capacity] = Shop.buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                System.out.println("Заказ: №" + (capacity + 1001) + " успешно обработан.");
                System.out.println("Информация по заказу:\n" + Shop.getOrders()[capacity]);
                capacity++;
            } catch (ProductException | CustomerException | AmountException e) {
                e.printStackTrace();
            }
            ++i;
        }

    }

}
