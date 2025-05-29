package com.pluralsight;

public class MeatType {
    public static final MeatType STEAK = new MeatType("STEAK", 1.00);
    public static final MeatType HAM = new MeatType("HAM", 1.00);
    public static final MeatType SALAMI = new MeatType("SALAMI", 1.00);
    public static final MeatType ROAST_BEEF = new MeatType("ROAST_BEEF", 1.00);
    public static final MeatType CHICKEN = new MeatType("CHICKEN", 1.00);
    public static final MeatType BACON = new MeatType("BACON", 1.00);

    private final String name;
    private final double price;

    private MeatType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static MeatType[] values() {
        return new MeatType[] { STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON };
    }
}