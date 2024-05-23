package org.example.hw4;

import javax.naming.InsufficientResourcesException;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public Account(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(String.format("Начальный баланс отрицательный. " +
                    "Введите сумму выше или равную 0. Введенный баланс = %.2f", balance));
        }
        this.balance = balance;
    }

    public void put(double num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException(String.format("Сумма отрицательная или равна нуля. num = %.2f.", num));
        }
        balance += num;
        System.out.printf("Ваш баланс: %.2f. +%.2f\n", balance, num);
    }

    public void take(double num) throws IllegalArgumentException, InsufficientResourcesException {
        if (num <= 0) {
            throw new IllegalArgumentException(String.format("Сумма отрицательная или равна нуля. num = %.2f.", num));
        }
        if (num > balance) {
            throw new InsufficientResourcesException(String.format("Сумма снятия превышает сумму баланса. " +
                    "balance = %.2f num = %.2f", balance, num));
        }
        balance -= num;
        System.out.printf("Ваш баланс: %.2f. -%.2f\n", balance, num);
    }

}
