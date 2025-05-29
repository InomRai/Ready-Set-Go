package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Menu {
    private BreadType bread;
    private double sizePrice;
    private List<MeatType> meats;
    private List<CheeseType> cheeses;
    private List<RegularTopping> toppings;
    private boolean toasted;

    public Sandwich(String name, BreadType bread, double sizePrice) {
        super(name, 0); // we'll calculate total price later
        this.bread = bread;
        this.sizePrice = sizePrice;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public void addMeat(MeatType meat) {
        meats.add(meat);
    }

    public void addCheese(CheeseType cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(RegularTopping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double total = bread.getPrice() + sizePrice;
        for (MeatType meat : meats) {
            total += meat.getPrice();
        }
        for (CheeseType cheese : cheeses) {
            total += cheese.getPrice();
        }
        // toppings are free
        return total;
    }

    @Override
    public void displayDetails() {
        System.out.println("Sandwich: " + getName());
        System.out.println("Bread: " + bread + " ($" + bread.getPrice() + ")");
        System.out.println("Size Price: $" + sizePrice);

        System.out.println("Meats:");
        for (MeatType meat : meats) {
            System.out.println("  - " + meat + " ($" + meat.getPrice() + ")");
        }

        System.out.println("Cheeses:");
        for (CheeseType cheese : cheeses) {
            System.out.println("  - " + cheese + " ($" + cheese.getPrice() + ")");
        }

        System.out.println("Toppings:");
        for (RegularTopping topping : toppings) {
            System.out.println("  - " + topping + " ($" + topping.getPrice() + ")");
        }

        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.printf("Total Sandwich Price: $%.2f\n", getPrice());
    }
}