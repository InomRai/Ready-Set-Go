package com.pluralsight;

import com.pluralsight.beverage.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetsetGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("\n=== Welcome to the GetsetGo System ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Menu> orderItems = new ArrayList<>();

                    // Create sandwich
                    Sandwich sandwich = createSandwich(scanner);
                    orderItems.add(sandwich);

                    // Add drink
                    Drink drink = createDrink(scanner);
                    orderItems.add(drink);

                    // Add chips
                    Chips chips = createChips(scanner);
                    orderItems.add(chips);

                    // Print and save receipt
                    Receipt receipt = new Receipt(orderItems);
                    receipt.printReceipt();

                    // Ask if user wants to continue
                    System.out.print("\nWould you like to place another order? (yes/no): ");
                    String response = scanner.nextLine();
                    continueOrdering = response.equalsIgnoreCase("yes");
                    break;

                case 0:
                    System.out.println("Thank you for using the DELI-cious POS System!");
                    continueOrdering = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static Sandwich createSandwich(Scanner scanner) {
        System.out.println("\nCreating a new sandwich...");

        // Select bread type
        System.out.println("Select bread type:");
        for (int i = 0; i < BreadType.values().length; i++) {
            BreadType bread = BreadType.values()[i];
            System.out.println((i + 1) + ") " + bread.getName() + " ($" + bread.getPrice() + ")");
        }

        System.out.print("Enter choice: ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();
        BreadType bread = BreadType.values()[breadChoice - 1];

        // Select sandwich size
        System.out.println("Select sandwich size:");
        System.out.println("1) 4 inch ($5.50)");
        System.out.println("2) 8 inch ($7.00)");
        System.out.println("3) 12 inch ($8.50)");
        System.out.print("Enter choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();
        double sizePrice;

        switch (sizeChoice) {
            case 1:
                sizePrice = 5.50;
                break;
            case 2:
                sizePrice = 7.00;
                break;
            case 3:
                sizePrice = 8.50;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 8 inch.");
                sizePrice = 7.00;
        }

        Sandwich sandwich = new Sandwich("Custom Sandwich", bread, sizePrice);

        // Meats
        System.out.println("Select meats to add:");
        for (int i = 0; i < MeatType.values().length; i++) {
            MeatType meat = MeatType.values()[i];
            System.out.println((i + 1) + ") " + meat.getName() + " ($" + meat.getPrice() + ")");
        }
        System.out.print("Enter meat choices (comma separated): ");
        String[] meatChoices = scanner.nextLine().split(",");
        for (String choice : meatChoices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            sandwich.addMeat(MeatType.values()[index]);
        }

        //ask user if they want extra meet
        System.out.print("Would you like to add extra meat? (yes/no): ");
        String extraMeatChoice = scanner.nextLine();
        if (extraMeatChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter extra meat choices (comma separated): ");
            String[] extraMeats = scanner.nextLine().split(",");
            for (String choice : extraMeats) {
                int meatIndex = Integer.parseInt(choice.trim()) - 1;
                sandwich.addMeat(MeatType.values()[meatIndex]);
            }
        }


        // Cheeses
        System.out.println("Select cheeses to add:");
        for (int i = 0; i < CheeseType.values().length; i++) {
            CheeseType cheese = CheeseType.values()[i];
            System.out.println((i + 1) + ") " + cheese.getName() + " ($" + cheese.getPrice() + ")");
        }
        System.out.print("Enter cheese choices (comma separated): ");
        String[] cheeseChoices = scanner.nextLine().split(",");
        for (String choice : cheeseChoices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            sandwich.addCheese(CheeseType.values()[index]);
        }


        // Ask if user wants extra cheese
        System.out.print("Would you like to add extra cheese? (yes/no): ");
        String extraCheeseChoice = scanner.nextLine();
        if (extraCheeseChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter extra cheese choices (comma separated): ");
            String[] extraCheeses = scanner.nextLine().split(",");
            for (String choice : extraCheeses) {
                int cheeseIndex = Integer.parseInt(choice.trim()) - 1;
                sandwich.addCheese(CheeseType.values()[cheeseIndex]);
            }
        }

        // Toppings
        System.out.println("Select regular toppings to add:");
        for (int i = 0; i < RegularTopping.values().length; i++) {
            RegularTopping topping = RegularTopping.values()[i];
            System.out.println((i + 1) + ") " + topping.getName() + " ($" + topping.getPrice() + ")");
        }
        System.out.print("Enter topping choices (comma separated): ");
        String[] toppingChoices = scanner.nextLine().split(",");
        for (String choice : toppingChoices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            sandwich.addTopping(RegularTopping.values()[index]);
        }

        // Toast
        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        String toast = scanner.nextLine();
        sandwich.setToasted(toast.equalsIgnoreCase("yes"));

        return sandwich;
    }

    private static Drink createDrink(Scanner scanner) {
        System.out.println("\nSelect drink size:");
        for (int i = 0; i < DrinkSize.values().length; i++) {
            DrinkSize size = DrinkSize.values()[i];
            System.out.println((i + 1) + ") " + size.getName() + " ($" + size.getPrice() + ")");
        }
        System.out.print("Enter choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();
        DrinkSize size = DrinkSize.values()[sizeChoice - 1];

        System.out.println("Select drink flavor:");
        String[] flavors = {"Coca Cola", "Sprite", "Mountain Dew", "Pepsi", "Red Bull"};
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i]);
        }
        System.out.print("Enter choice: ");
        int flavorChoice = scanner.nextInt();
        scanner.nextLine();
        String flavor = flavors[Math.max(0, Math.min(flavorChoice - 1, flavors.length - 1))];

        return new Drink("Custom Drink", size, flavor);
    }

    private static Chips createChips(Scanner scanner) {
        System.out.println("\nSelect chip type:");
        for (int i = 0; i < ChipType.values().length; i++) {
            ChipType chip = ChipType.values()[i];
            System.out.println((i + 1) + ") " + chip.getName() + " ($" + chip.getPrice() + ")");
        }
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        ChipType type = ChipType.values()[choice - 1];

        return new Chips("Custom Chips", type);
    }

    private static void displayOrderDetails(List<Menu> orderItems) {
        System.out.println("\nOrder Details:");
        double total = 0;
        for (Menu item : orderItems) {
            item.displayDetails();
            total += item.getPrice();
        }
        System.out.printf("Total Order Price: $%.2f%n", total);
    }
}
