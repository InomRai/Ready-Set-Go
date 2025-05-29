package com.pluralsight;

public class ChipType {
    public static final ChipType REGULAR = new ChipType("REGULAR", 1.50);
    public static final ChipType BBQ = new ChipType("BBQ", 1.50);
    public static final ChipType SOUR_CREAM = new ChipType("SOUR_CREAM", 1.50);
    public static final ChipType CHEESE = new ChipType("CHEESE", 1.50);

    private final String name;
    private final double price;

    private static final ChipType[] values = { REGULAR, BBQ, SOUR_CREAM, CHEESE };

    private ChipType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static ChipType[] values() {
        return values;
    }
}

