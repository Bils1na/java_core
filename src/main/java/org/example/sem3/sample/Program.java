package org.example.sem3.sample;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new ConcretePrudct());
        products.add(new ConcretePrudct2());
        products.add(new ConcretePrudct3());

        processProducts(products);
    }

    static void processProducts(ArrayList<Product> list) {
        for (Product product : list) {
            System.out.println(product.getName());
        }
    }

}
