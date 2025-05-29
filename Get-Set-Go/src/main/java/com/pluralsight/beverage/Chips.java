package com.pluralsight.beverage;

import com.pluralsight.Subs.Menu;

public class Chips extends Menu {
    private ChipType type;

    public Chips(String name, ChipType type) {
        super(name, type.getPrice());
        this.type = type;
    }

    @Override
    public void displayDetails() {
        System.out.println("Chips: " + getName());
        System.out.println("Type: " + type);
        System.out.println("Total Price: $" + getPrice());
    }

    public static class ChipType {
        public static final ChipType Lays = new ChipType("Lays", 1.50);
        public static final ChipType BBQ = new ChipType("BBQ", 1.50);
        public static final ChipType HotCheetos= new ChipType("HotCheetos", 1.50);
        public static final ChipType Doritos = new ChipType("Doritos", 1.50);

        private final String name;
        private final double price;

        private static final ChipType[] values = { Lays, BBQ, HotCheetos, Doritos };

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
}

