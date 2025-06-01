package com.pluralsight.beverage;

public class CheeseType {
    public static final CheeseType AMERICAN = new CheeseType("AMERICAN", 0.75);
    public static final CheeseType PROVOLONE = new CheeseType("PROVOLONE", 0.75);
    public static final CheeseType CHEDDAR = new CheeseType("CHEDDAR", 0.75);
    public static final CheeseType SWISS = new CheeseType("SWISS", 0.75);

    private final String name;
    private final double price;

    private static final CheeseType[] values = { AMERICAN, PROVOLONE, CHEDDAR, SWISS };

    private CheeseType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static CheeseType[] values() {
        return values;
    }

    @Override
    public String toString() {
        return String.format("CheeseType{name= %s, price=%.2f}", name, price);
    }
}