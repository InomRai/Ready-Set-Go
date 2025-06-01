package com.pluralsight.App;

import com.pluralsight.Subs.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Receipt {
    private List<Menu> items;
    private String savedReceipt;  // Holds the receipt as a string

    public Receipt(List<Menu> items) {
        this.items = items;
    }

    public String printReceipt() {
        StringBuilder receiptText = new StringBuilder();
        double total = 0.0;

        receiptText.append("\n========== Get set Go ==========\n");

        if (items == null || items.isEmpty()) {
            receiptText.append("No items ordered.\n");
        } else {
            for (Menu item : items) {
                if (item != null) {  // <- Check null before using item
                    receiptText.append(getItemDetails(item))
                            .append("----------------------------------------\n");
                    total += item.getPrice();
                }
            }
        }

        receiptText.append(String.format("TOTAL: $%.2f\n", total));
        receiptText.append("========================================\n");
        receiptText.append("Thank you for dining with us!\n");

        savedReceipt = receiptText.toString();  // Save to field

        System.out.println(savedReceipt);

        try (PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt"))) {
            writer.print(savedReceipt);
            System.out.println("Receipt saved as 'receipt.txt' in the working directory.");
        } catch (IOException e) {
            System.out.println("Failed to write receipt to file: " + e.getMessage());
        }

        return savedReceipt;  // Return the receipt string
    }

    private String getItemDetails(Menu item) {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream oldOut = System.out;
        System.setOut(new java.io.PrintStream(baos));
        item.displayDetails();
        System.setOut(oldOut);
        return baos.toString();
    }

    public String getSavedReceipt() {
        return savedReceipt;
    }
}