package org.example.jdk_hw3;

public class Pair <T, V> {
    private T firstValue;
    private V secondValue;

    public Pair(T firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getFirstValue(), getSecondValue());
    }
}
