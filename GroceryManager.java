import java.util.*;
import java.io.*;

public class GroceryManager {
    private static ArrayList<String> neededItems;
    private static String[] purchasedItems;
    private static int purchasedIndex = 0;
    private static final int MAX_PURCHASED = 100;

    public static void main(String[] args) {
        neededItems = FileHandler.loadList("neededItems.txt");
        purchasedItems = FileHandler.loadArray("purchasedItems.txt", MAX_PURCHASED);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nGrocery List Manager:");
            System.out.println("1. Add item to needed list");
            System.out.println("2. View needed items");
            System.out.println("3. Mark item as purchased");
            System.out.println("4. View purchased items");
            System.out.println("5. Exit and Save");

            choice = InputValidator.getIntInput("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewNeededItems();
                case 3 -> markAsPurchased();
                case 4 -> viewPurchasedItems();
                case 5 -> {
                    FileHandler.saveList(neededItems, "neededItems.txt");
                    FileHandler.saveArray(purchasedItems, "purchasedItems.txt");
                    System.out.println("Data saved. Goodbye!");
                }
            }
        } while (choice != 5);
    }

    private static void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine();
        neededItems.add(item);
        System.out.println(item + " added to needed list.");
    }

    private static void viewNeededItems() {
        System.out.println("\nNeeded Items:");
        if (neededItems.isEmpty()) {
            System.out.println("No items.");
        } else {
            for (int i = 0; i < neededItems.size(); i++) {
                System.out.println(i + ": " + neededItems.get(i));
            }
        }
    }

    private static void markAsPurchased() {
        if (neededItems.isEmpty()) {
            System.out.println("Nothing to purchase.");
            return;
        }
        viewNeededItems();
        int index = InputValidator.getIntInput("Enter index of item to mark as purchased: ", 0, neededItems.size() - 1);
        if (purchasedIndex < MAX_PURCHASED) {
            purchasedItems[purchasedIndex++] = neededItems.remove(index);
            System.out.println("Item marked as purchased.");
        } else {
            System.out.println("Purchased items list is full!");
        }
    }

    private static void viewPurchasedItems() {
        System.out.println("\nPurchased Items:");
        if (purchasedIndex == 0) {
            System.out.println("No purchased items.");
        } else {
            for (int i = 0; i < purchasedIndex; i++) {
                System.out.println(purchasedItems[i]);
            }
        }
    }
} 