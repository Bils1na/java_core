package org.example.jdk_hw3;

public class Program {

    public static void main(String[] args) {
//        System.out.println(Calculator.sum(1, 0.1));
//        System.out.println(Calculator.sum(1.1, 0.1));
//        System.out.println(Calculator.sum(1.1, 1));
//
//        System.out.println(Calculator.multiply(1, 0.1));
//        System.out.println(Calculator.multiply(1.1, 0.1));
//        System.out.println(Calculator.multiply(1.1, 1));
//
//        System.out.println(Calculator.divide(1, 0.25));
//        System.out.println(Calculator.divide(1.1, 0.1));
//        System.out.println(Calculator.divide(1.1, 1));
//
//        System.out.println(Calculator.subtract(1, 0.1));
//        System.out.println(Calculator.subtract(1.1, 0.1));
//        System.out.println(Calculator.subtract(1.1, 1));

        String[] strings1 = {"Hi", "Hello", "Hey"};
        String[] strings2 = {"Hi", "Hey", "Hello", "Ge"};

        Integer[] digits2 = {1, 2, 3, 4};
        Integer[] digits1 = {1, 2, 3};

        if (compareArrays(strings1, strings2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        if (compareArrays(digits1, digits2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

//    Напишите обобщенный метод compareArrays(), который принимает два массива и
//    возвращает true, если они одинаковые, и false в противном случае. Массивы
//    могут быть любого типа данных, но должны иметь одинаковую длину и содержать
//    элементы одного типа по парно по индексам.

    static <T, V> boolean compareArrays(T[] array1, V[] array2) {
        if (!(array1.length == array2.length)) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().getName().equals(array2[i].getClass().getName())) {
                return false;
            }
        }
        return true;
    }

}
