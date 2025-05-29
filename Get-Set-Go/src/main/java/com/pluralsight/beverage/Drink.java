package com.pluralsight.beverage;

import com.pluralsight.DrinkSize;
import com.pluralsight.Menu;

public class Drink extends Menu {
    private DrinkSize size;
    private String flavor;

    public Drink(String name, DrinkSize size, String flavor) {
        super(name, size.getPrice());
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public void displayDetails() {
        System.out.println("Drink: " + getName());
        System.out.println("Size: " + size);
        System.out.println("Flavor: " + flavor);
        System.out.println("Total Price: $" + getPrice());
    }
}
