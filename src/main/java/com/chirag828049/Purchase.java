package com.chirag828049;

public class Purchase {

    private int ID;
    private Customer customer;
    private Product product;
    private int quantity;

    protected Purchase(int ID, Customer customer, Product product, int quantity) {

        this.ID = ID;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    protected int getID() {

        return this.ID;
    }

    protected Customer getCustomer() {

        return this.customer;
    }

    protected Product getProduct() {

        return this.product;
    }

    protected int getQuantity() {

        return this.quantity;
    }
}
