package com.pluralsight;

public class RegularTopping {
    public static final RegularTopping LETTUCE = new RegularTopping("LETTUCE", 0.00);
    public static final RegularTopping PEPPERS = new RegularTopping("PEPPERS", 0.00);
    public static final RegularTopping ONIONS = new RegularTopping("ONIONS", 0.00);
    public static final RegularTopping TOMATOES = new RegularTopping("TOMATOES", 0.00);
    public static final RegularTopping JALAPENOS = new RegularTopping("JALAPENOS", 0.00);
    public static final RegularTopping CUCUMBERS = new RegularTopping("CUCUMBERS", 0.00);
    public static final RegularTopping PICKLES = new RegularTopping("PICKLES", 0.00);
    public static final RegularTopping GUACAMOLE = new RegularTopping("GUACAMOLE", 0.00);
    public static final RegularTopping MUSHROOMS = new RegularTopping("MUSHROOMS", 0.00);

    private final String name;
    private final double price;

    private static final RegularTopping[] values = {
            LETTUCE, PEPPERS, ONIONS, TOMATOES,
            JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
    };

    private RegularTopping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static RegularTopping[] values() {
        return values;
    }
}