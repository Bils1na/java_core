package org.example.lec5;

import java.io.File;

public class Program {

    public static void main(String[] args) {
//        File folder = new File("./src/main/java/org/example");
//
//        for (File file : folder.listFiles()) {
//            System.out.println(file.getName());
//        }

        long timeStart = System.nanoTime();
        String s = "Example";
        for (int i = 0; i < 200000 ; i++) {
            s = s + i;
        }
        double deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time (sec): " + deltaTime);

        timeStart = System.nanoTime();
        StringBuilder sb = new StringBuilder("Example");
        for (int i = 0; i < 200000 ; i++) {
            sb.append(i);
        }
        deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time (sec): " + deltaTime);

        System.out.println(s.equals(sb.toString()));
    }

}
