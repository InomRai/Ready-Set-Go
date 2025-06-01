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
        public static final ChipType LAYS = new ChipType("Lays", 1.50);
        public static final ChipType BBQ = new ChipType("BBQ", 1.50);
        public static final ChipType HOT_CHEETOS = new ChipType("Hot Cheetos", 1.50);
        public static final ChipType DORITOS = new ChipType("Doritos", 1.50);

        private final String name;
        private final double price;

        private static final ChipType[] values = { LAYS, BBQ, HOT_CHEETOS, DORITOS };

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

        @Override
        public String toString() {
            return String.format("%s ($%.2f)", name, price);
        }
    }
}