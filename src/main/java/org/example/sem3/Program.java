package org.example.sem3;

public class Program {

    public static void main(String[] args) {

        try {
//            Human human1 = new Human("User", -28);
            Human baseHuman2 = Human.create("User", -28, 100, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
