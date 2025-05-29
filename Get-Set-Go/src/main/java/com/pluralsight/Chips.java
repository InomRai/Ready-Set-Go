package com.pluralsight;

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
}

