package com.chirag828049;

public class Product extends Entity {

    private Manufacturer myManufacturer;

    protected Product(int ID, String name, Manufacturer myManufacturer) {
        super(ID, name);
        this.myManufacturer = myManufacturer;
    }

    Manufacturer getManufacturer() {

        return this.myManufacturer;
    }
}
