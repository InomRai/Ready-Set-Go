package com.pluralsight.App;

import com.pluralsight.Subs.MeatType;
import com.pluralsight.Subs.Menu;
import com.pluralsight.Subs.RegularTopping;
import com.pluralsight.Subs.Sandwich;
import com.pluralsight.beverage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    static Scanner scanner = new Scanner(System.in);
    static List<Menu> orderItems = new ArrayList<>(); // using this array list for now
    //however we should be creating an Order class


    public static void orderScreen(){

        boolean continueOrdering = true;

        while (continueOrdering) {

            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Cancel
                    """);
            String selection = scanner.nextLine();

            switch (selection) {

                case "1":
                    // Create sandwich
                    Sandwich sandwich = createSandwich(scanner);
                    orderItems.add(sandwich);
                    System.out.println("Sandwich has been added to your order;");
                    break;

                case "2":
                    // Add drink
                    Drink drink = createDrink(scanner);
                    if (drink != null) {
                        orderItems.add(drink);
                        System.out.println("Drink has been added to your order");
                    }
                    break;

                case "3":

                    // Add chips
                    Chips chips = createChips(scanner);
                    if (chips != null) {
                        orderItems.add(chips);
                        System.out.println("Chips has been added to your order");
                    }
                    break;

                case "4":
                    // Print and save receipt
                    //checkout should display the order items first
                    //then ask the user to confirm the order aka generate the receipt
                    //or cancel the order aka take them back to the 'home screen'
                    Receipt receipt = new Receipt(orderItems);
                    receipt.printReceipt();

                    // Ask if user wants to continue
                    System.out.print("\nWould you like to place another order? (yes/no): ");
                    String response = scanner.nextLine();
                    continueOrdering = response.equalsIgnoreCase("yes");
                    //for a new order we should probably empty out the arraylist that had the previous order
                    orderItems = new ArrayList<>();
                    break;

                case "5":
                    System.out.print("\nCancel? Do you want to continue ordering? (yes/no): ");
                   String response2 = scanner.nextLine();
                    continueOrdering = response2.equalsIgnoreCase("yes"); //it's true but we need it to = false
                    break;
                default:
                    System.out.println("Error: Unable to process request. Please try again.");

            }
        }
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
        double sizePrice = 0.0;

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

        // Determine extra meat charge based on sandwich size
        double extraMeatCharge = 0.0;
        System.out.print("Would you like to add extra meat? (yes/no): ");
        String extraMeatChoice = scanner.nextLine();
        if (extraMeatChoice.equalsIgnoreCase("yes")) {
            switch (sizeChoice) {
                case 1: // 4 inch
                    extraMeatCharge = 0.50;
                    break;
                case 2: // 8 inch
                    extraMeatCharge = 1.00;
                    break;
                case 3: // 12 inch
                    extraMeatCharge = 1.50;
                    break;
            }

            System.out.print("Enter extra meat choices (comma separated): ");
            String[] extraMeats = scanner.nextLine().split(",");
            for (String choice : extraMeats) {
                int meatIndex = Integer.parseInt(choice.trim()) - 1;
                sandwich.addMeat(MeatType.values()[meatIndex]);
                System.out.printf("Extra meat added. An additional $%.2f has been charged.%n", extraMeatCharge);
            }
        }

        System.out.println("Select cheese to add:");
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

        double extraCheeseCharge = 0.0;
        System.out.print("Would you like to add extra cheese? (yes/no): ");
        String extraCheeseChoice = scanner.nextLine();
        if (extraCheeseChoice.equalsIgnoreCase("yes")) {
            switch (sizeChoice) {
                case 1: // 4 inch
                    extraCheeseCharge = 0.30;
                    break;
                case 2: // 8 inch
                    extraCheeseCharge = 0.60;
                    break;
                case 3: // 12 inch
                    extraCheeseCharge = 0.90;
                    break;
            }

            System.out.print("Enter extra cheese choices (comma separated): ");
            String[] extraCheeses = scanner.nextLine().split(",");
            for (String choice : extraCheeses) {
                int cheeseIndex = Integer.parseInt(choice.trim()) - 1;
                sandwich.addCheese(CheeseType.values()[cheeseIndex]);
                System.out.printf("Extra cheese added. An additional $%.2f has been charged.%n", extraCheeseCharge);
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
        // Ask if the user wants to add a drink
        System.out.print("Would you like to add a drink to your order? (yes/no): ");
        String addDrinkResponse = scanner.nextLine().trim().toLowerCase();

        // If the user wants a drink, proceed with drink selection
        if (addDrinkResponse.equals("yes")) {
            System.out.println("\nSelect drink size:");
            for (int i = 0; i < DrinkSize.values().length; i++) {
                DrinkSize size = DrinkSize.values()[i];
                System.out.println((i + 1) + ") " + size.getName() + " ($" + size.getPrice() + ")");
            }
            System.out.print("Enter choice: ");
            int sizeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            DrinkSize size = DrinkSize.values()[sizeChoice - 1];

            System.out.println("Select drink flavor:");
            String[] flavors = {"Coca Cola", "Sprite", "Mountain Dew", "Pepsi", "Red Bull"};
            for (int i = 0; i < flavors.length; i++) {
                System.out.println((i + 1) + ") " + flavors[i]);
            }
            System.out.print("Enter choice: ");
            int flavorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String flavor = flavors[Math.max(0, Math.min(flavorChoice - 1, flavors.length - 1))];

            return new Drink("Custom Drink", size, flavor);
        } else {
            System.out.println("No drink added to your order.");
            return null; // No drink added
        }
    }

    private static Chips createChips(Scanner scanner) {
        // Ask the user if they want chips
        System.out.print("Would you like to add chips to your order? (yes/no): ");
        String chipsChoice = scanner.nextLine().trim().toLowerCase();

        // Validate input
        while (!chipsChoice.equals("yes") && !chipsChoice.equals("no")) {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            System.out.print("Would you like to add chips to your order? (yes/no): ");
            chipsChoice = scanner.nextLine().trim().toLowerCase();
        }

        // If the user doesn't want chips, return null
        if (chipsChoice.equals("no")) {
            return null;
        }

        // If the user wants chips, proceed with chip selection
        System.out.println("\nSelect chip type:");
        for (int i = 0; i < Chips.ChipType.values().length; i++) {
            Chips.ChipType chip = Chips.ChipType.values()[i];
            System.out.println((i + 1) + ") " + chip.getName() + " ($" + chip.getPrice() + ")");
        }
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        Chips.ChipType type = Chips.ChipType.values()[choice - 1];

        return new Chips("Custom Chips", type);
    }

}
