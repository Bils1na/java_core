package org.example.jdk_hw3;

public class Program {

    public static void main(String[] args) {
        System.out.println(Calculator.sum(1, 0.1));
        System.out.println(Calculator.sum(1.1, 0.1));
        System.out.println(Calculator.sum(1.1, 1));

        System.out.println(Calculator.multiply(1, 0.1));
        System.out.println(Calculator.multiply(1.1, 0.1));
        System.out.println(Calculator.multiply(1.1, 1));

        System.out.println(Calculator.divide(1, 0.25));
        System.out.println(Calculator.divide(1.1, 0.1));
        System.out.println(Calculator.divide(1.1, 1));

        System.out.println(Calculator.subtract(1, 0.1));
        System.out.println(Calculator.subtract(1.1, 0.1));
        System.out.println(Calculator.subtract(1.1, 1));
    }

//    Напишите обобщенный метод compareArrays(), который принимает два массива и
//    возвращает true, если они одинаковые, и false в противном случае. Массивы
//    могут быть любого типа данных, но должны иметь одинаковую длину и содержать
//    элементы одного типа по парно по индексам.

    <T> boolean compareArrays(T[] array1, T[] array2) {
        return true;
    }

}
