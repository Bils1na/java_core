package org.example.hw4;

import javax.naming.InsufficientResourcesException;

public class Program {

    public static void main(String[] args) {
        Account account = null;

        try {
            account = new Account(100);
//            account = new Account(-1000);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println("Ваш баланс: " + account.getBalance());

//        for (int i = -10; i <= 100; i += 10) {
//            try {
//                account.put(i);
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }

        for (int i = -10; i <= 100; i += 10) {
            try {
                account.take(i);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            }
        }
    }

}
