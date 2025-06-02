package com.pluralsight.App;

import com.pluralsight.Subs.MeatType;
import com.pluralsight.Subs.Menu;
import com.pluralsight.Subs.RegularTopping;
import com.pluralsight.Subs.Sandwich;
import com.pluralsight.beverage.*;

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
                    OrderView.orderScreen();
                    break;

                case 0:
                    System.out.println("Thank you for using the GetsetGo System!");
                    continueOrdering = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }



}