package com.pluralsight;


public class BreadType {
    public static final BreadType WHITE = new BreadType("WHITE", 5.50);
    public static final BreadType WHEAT = new BreadType("WHEAT", 5.50);
    public static final BreadType RYE = new BreadType("RYE", 5.50);
    public static final BreadType WRAP = new BreadType("WRAP", 5.50);

    private final String name;
    private final double price;

    private static final BreadType[] values = { WHITE, WHEAT, RYE, WRAP };

    private BreadType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static BreadType[] values() {
        return values;
    }
}