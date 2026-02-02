package com.krapa.clothingstore.clothes;

import com.krapa.clothingstore.database.ClothingItemDAO;
import com.krapa.clothingstore.model.*;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner; //Allows us to read user input
import java.util.List;

import static java.lang.System.*;

public class ClothingItemStock implements Clothes { // main class

    private final Scanner scanner;
    private final ClothingItemDAO clothingItemDAO;

    public ClothingItemStock() {

        out.println();
        out.println("===Clothing Store Management System==="); // Welcome message
        out.println();
        //Description
        out.println("This program's purposes are to:");
        out.println("Record and store, manage all data about clothing store such as:");
        out.println("-Clothes inventory: items, sizes, brands");
        out.println("-Customers and employee information");
        out.println("-Orders information");
        out.println();
        out.println("Name: Kira");
        out.println("Course: IT-2505");
        out.println();
        out.println("Console menu application");
        out.println();

        scanner = new Scanner(in);
        clothingItemDAO = new ClothingItemDAO();
    }

    //Display clothing items

    @Override
    public void displayInventory() {
        out.println("========================================");
        out.println("    CLOTHING STORE MANAGEMENT SYSTEM");
        out.println("========================================");
        out.println();
        out.println("========================================");
        out.println("CLOTHING ITEMS MANAGEMENT");
        out.println("========================================");
        out.println("1. View All Clothing Items");
        out.println("2. Update Clothing Item");
        out.println("3. Delete Clothing Item");
        out.println("4. Add Shirt");
        out.println("========================================");
        out.println("SEARCH & FILTER");
        out.println("========================================");
        out.println("5.Search by Name");
        out.println("6.Search by Price Range");
        out.println("7.High-Price Clothes (Price>=X)");
        out.println("========================================");
        out.println("DEMO & OTHER");
        out.println("========================================");
        out.println("8. Demonstrate Polymorphism");
        out.println("0. Exit");
        out.println();
        out.println("========================================");
        out.println();
        out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayInventory(); // Show menu options
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // IMPORTANT: consume leftover newline
                switch (choice) {
                    case 1:
                        viewAllClothingItems();
                        break;
                    case 2:
                        updateClothingItems();
                        break;
                    case 3:
                        deleteClothingItem();
                        break;
                    case 4:
                        addShirt();
                        break;
                    case 5:
                        searchClothingByName();
                        break;
                    case 6:
                        searchClothingByPrice();
                        break;
                    case 7:
                        searchHighPriceClothes();
                        break;
                    case 8:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        out.println("\n\uD83D\uDC4B Goodbye!");
                        running = false; // Exit loop
                        break;
                    default:
                        out.println("\n❌ Invalid choice!");
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    } // End of main method

        // Adds Shirt object

        private void addShirt() {

        System.out.println("\n--- ADD SHIRT ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Size: ");
        String size = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        String type = "SHIRT";
        Shirt shirt = new Shirt(0, name, price, size, brand, quantity, type);
        clothingItemDAO.insertClothingItem(shirt);
    }

        // Shows all clothing items

        private void viewAllClothingItems() {

        out.println("\n========================================");
        out.println("           ALL CLOTHING ITEMS");
        out.println("========================================");
        out.println();

        clothingItemDAO.getAllClothingItems();
    }

        //Method to demonstrate polymorphism

        private void demonstratePolymorphism () {

            out.println("\n========================================");
            out.println("       POLYMORPHISM DEMONSTRATION");
            out.println("========================================");
            out.println();

            out.println("Calling printInfo() on all clothing items:");
            out.println();

            List<ClothingItem> items = clothingItemDAO.searchByName("");

            for (ClothingItem item : items) {
                item.printInfo();
            }
        }

        //Method to update clothing items

        private void updateClothingItems() {

        out.print("Enter Clothing Item ID to update: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        // 1. Load current data from database
        ClothingItemDAO dao = new ClothingItemDAO();
        ClothingItem existingClothingItem = dao.getItemById(itemId);
        if (existingClothingItem == null) {
            out.println("❌ No clothing item found with ID: " + itemId);
            return;
        }
        // 2. Display current info
        out.println("Current Info:");
        out.println(existingClothingItem.toString());
        // 3. Get new values (press Enter to keep current)
        out.print("New Name [" + existingClothingItem.getItemName() + "]: ");
        String newName = scanner.nextLine();
        if (newName.trim().isEmpty()) {
            newName = existingClothingItem.getItemName(); // Keep current
        }
        out.print("New Price [" + existingClothingItem.getItemPrice() + "]: ");
        String priceInput = scanner.nextLine();
        double newPrice = priceInput.trim().isEmpty() ?
                existingClothingItem.getItemPrice() :
                Double.parseDouble(priceInput);
        out.print("New Size [" + existingClothingItem.getItemSize() + "]: ");
        String newSize = scanner.nextLine();
        if (newSize.trim().isEmpty()) {
            newSize = existingClothingItem.getItemSize(); // Keep current
        }
        out.print("New Brand [" + existingClothingItem.getItemBrand() + "]: ");
        String newBrand = scanner.nextLine();
        if (newBrand.trim().isEmpty()) {
            newBrand = existingClothingItem.getItemBrand(); // Keep current
        }
        out.print("New Quantity [" + existingClothingItem.getItemQuantity() + "]: ");
        String quantityInput = scanner.nextLine();
        int newQuantity = quantityInput.trim().isEmpty() ?
                existingClothingItem.getItemQuantity() :
                Integer.parseInt(quantityInput);
        // 4. Update based on type
        if (existingClothingItem instanceof Shirt) {
                Shirt updatedShirt = new Shirt(itemId, newName, newPrice, newSize, newBrand, newQuantity, existingClothingItem.getItemType());
                dao.updateShirt(updatedShirt);
            }
        }

        //Method to delete clothing items

        private void deleteClothingItem() {

        System.out.print("Enter Clothing Item ID to delete: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        // 1. First, load and show what will be deleted
        ClothingItemDAO dao = new ClothingItemDAO();
        ClothingItem existingClothingItem = dao.getItemById(itemId);
        if (existingClothingItem == null) {
            System.out.println("❌ No Clothing Item found with ID: " + itemId);
            return;
        }
        // 2. Display clothing item details
        System.out.println("Clothing Item to delete:");
        System.out.println(existingClothingItem.toString());
        // 3. Ask for confirmation
        System.out.print("⚠\uFE0F Are you sure? (yes/no): ");
        String confirmation = scanner.nextLine();
        // 4. Delete only if confirmed
        if (confirmation.equalsIgnoreCase("yes")) {
            dao.deleteClothingItem(itemId);
        } else {
            System.out.println("❌ Deletion cancelled.");
            }
        }

        //Method to search clothing items by name

        private void searchClothingByName() {
            System.out.print("Enter name to search: ");
            String name = scanner.nextLine();

            List<ClothingItem> results = clothingItemDAO.searchByName(name);

            if (results.isEmpty()) {
                System.out.println("❌ No items found.");
                return;
            }

            for (ClothingItem item : results) {
                System.out.println(item);
            }
        }

        //Method to search clothing item by price

        private void searchClothingByPrice() {
            out.print("Min price: ");
            double min = scanner.nextDouble();
            out.print("Max price: ");
            double max = scanner.nextDouble();
            scanner.nextLine();

            List<ClothingItem> priceRange = clothingItemDAO.searchByPriceRange(min, max);

            if (priceRange.isEmpty()) {
                System.out.println("❌ No items found.");
                return;
            }
            for (ClothingItem item : priceRange) {
                System.out.println(item);
            }
        }

        //Method to search high price clothes (>=X)

        private void searchHighPriceClothes() {
            System.out.print("Enter minimum price to search: ");
            Double price = scanner.nextDouble();
            scanner.nextLine();

            List<ClothingItem> highPriceItems = clothingItemDAO.searchByMinPrice(price);

            if (highPriceItems.isEmpty()) {
                System.out.println("❌ No items found.");
                return;
            }
            for (ClothingItem item : highPriceItems) {
                System.out.println(item);
                }
            }
        }

