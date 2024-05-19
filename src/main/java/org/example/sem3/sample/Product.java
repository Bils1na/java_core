package org.example.sem3.sample;

public abstract class Product {

    private static  int counter;

    private String name;

    public Product() {
        name = String.format("Product #%d", ++counter);
    }

    public String getName() {
        return name;
    }
}
