package com.pluralsight.App;

import com.pluralsight.Subs.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;


public class Receipt {
    private List<Menu> items;

    public Receipt(List<Menu> items) {
        this.items = items;
    }

    public void printReceipt() {
        StringBuilder receiptText = new StringBuilder();
        double total = 0.0;

        receiptText.append("\n========== Get set Go ==========\n");

        for (Menu item : items) {
            // Capture console output
            receiptText.append(getItemDetails(item)).append("----------------------------------------\n");
            total += item.getPrice();
        }

        receiptText.append(String.format("TOTAL: $%.2f\n", total));
        receiptText.append("========================================\n");
        receiptText.append("Thank you for dining with us!\n");

        // Print to console
        System.out.println(receiptText);

        // Write to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt"))) {
            writer.print(receiptText);
            System.out.println(" Receipt saved as 'receipt.txt' in the working directory.");
        } catch (IOException e) {
            System.out.println(" Failed to write receipt to file: " + e.getMessage());
        }
    }

    // Utility to get item details as string
    private String getItemDetails(Menu item) {
        // Redirect output to a string (instead of System.out)
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(baos, true);
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(baos));

        item.displayDetails();

        System.setOut(oldOut); // Restore original System.out
        return baos.toString();
    }
}