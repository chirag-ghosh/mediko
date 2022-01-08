package com.chirag828049;

import java.util.Vector;

import org.javatuples.Pair;

public class Shop extends Entity {

    private int ZipCode;

    private Vector<Pair<Product, Integer>> productList = new Vector<Pair<Product, Integer>>();

    protected Shop(int ID, String name, int ZipCode) {

        super(ID, name);
        this.ZipCode = ZipCode;
    }

    protected int getZipCode() {

        return this.ZipCode;
    }

    protected void addProduct(Product newProduct, Integer quantity) {

        boolean isPresent[] = new boolean[1]; // using array because lambda expression inside foreach doesn't allow
                                              // changing value of local variable.
        isPresent[0] = false;

        productList.forEach((product) -> {
            if (product.getValue0() == newProduct) {
                product.setAt1(product.getValue1() + quantity);
                isPresent[0] = true;
            }
        });

        if (!isPresent[0]) {
            productList.add(new Pair<Product, Integer>(newProduct, quantity));
        }
    }

    protected int getQuantity(Product existingProduct) {

        int quantity[] = { 0 };

        productList.forEach((product) -> {
            if (product.getValue0() == existingProduct) {
                quantity[0] = product.getValue1().intValue();
            }
        });
        return quantity[0];
    }

    protected void decreaseQuantity(Product existingProduct, Integer decrease) {

        productList.forEach((product) -> {
            if (product.getValue0() == existingProduct) {
                product.setAt1(product.getValue1() - decrease);
            }
        });
    }
}