package org.example.lec2;

public class Main {
    public static void main(String[] args) {
        byte b0 = 100;
        short b1 = 200;
        int b3 = 200000;
        long b4 = 20000000000L;
        double b5 = 0.123;
        float b6 = 0.123f;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int sum(float a, float b) {
        return 0;
    }

}
