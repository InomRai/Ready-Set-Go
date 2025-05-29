package com.pluralsight;

public class DrinkSize {
    public static final DrinkSize SMALL = new DrinkSize("SMALL", 2.00);
    public static final DrinkSize MEDIUM = new DrinkSize("MEDIUM", 2.50);
    public static final DrinkSize LARGE = new DrinkSize("LARGE", 3.00);

    private final String name;
    private final double price;

    private static final DrinkSize[] values = { SMALL, MEDIUM, LARGE };

    private DrinkSize(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static DrinkSize[] values() {
        return values;
    }
}