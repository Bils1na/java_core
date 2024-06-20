package org.example.jdk_sem3;

public class Programm {

    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        fruitBox.add(new Orange());
        fruitBox.add(new Apple());

        System.out.println(appleBox.compare(orangeBox));

        orangeBox.transferTo(fruitBox);
//        orangeBox.transferTo(appleBox);
    }

}
