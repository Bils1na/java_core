package org.example.jdk_hw3;

public class Calculator {
//    Написать класс Калькулятор (необобщенный), который содержит обобщенные
//    статические методы: sum(), multiply(), divide(), subtract(). Параметры
//    этих методов – два числа разного типа, над которыми должна быть произведена операция.
//    Методы должны возвращать результат своей работы.

    public static <T extends Number, V extends Number> double sum(T t, V v) {
        return (t.doubleValue() + v.doubleValue());
    }

    public static <T extends Number, V extends Number> double multiply(T t, V v) {
        return (t.doubleValue() * v.doubleValue());
    }

    public static <T extends Number, V extends Number> double divide(T t, V v) {
        return (t.doubleValue() / v.doubleValue());
    }

    public static <T extends Number, V extends Number> double subtract(T t, V v) {
        return (t.doubleValue() - v.doubleValue());
    }

}
