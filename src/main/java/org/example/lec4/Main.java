package org.example.lec4;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    enum Color {
        RED("#FF0000"), GREEN("00FF00"), BLUE("0000FF");
        private String code;
        Color(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    private static class Orange {
        private Juice juice;

        public Orange() {
            this.juice = new Juice();
        }

        public void squeezeJuice() {
            System.out.println("Squeeze juice...");
            juice.flow();
        }

        private class Juice {
            public  void flow() {
                System.out.println("Juice dripped...");
            }
        }
    }

    static class TestStream implements Closeable {
        TestStream() throws IOException {
            System.out.println("construct OK");
            //throw new IOException();
        }
        int read() throws FileNotFoundException {
            new FileInputStream("file.txt");
            System.out.println("file OK");
            return 1;
        }
        public void close() throws IOException {
            System.out.println("close OK");
            throw new IOException();
        }
    }

    public static void main(String[] args) {
//        for (Color c : Color.values()) {
//            System.out.printf("%s(%s) ", c, c.getCode());
//        }

//        Orange orange = new Orange();
//        orange.squeezeJuice();
//        methodB();

        try (TestStream stream = new TestStream()) {
            int a = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        TestStream stream = null;
//        try {
//            stream = new TestStream();
//            int a = stream.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (stream != null) {
//                try {
//                    stream.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

    }

    public static void methodB() {
        try {
            throw new IOException();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }


}
