package com.krapa.clothingstore;

import java.util.ArrayList; //Allows us to use ArrayList
import java.util.Objects;
import java.util.Scanner; //Allows us to read user input

public class Main3 { // main class

    //Arrays. These ArrayLists store all our objects
    //'static' means they belong to the class, not individual objects
    //'private' keeps them protected

    private static ArrayList<ClothingItem> clothingItems = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    //Scanner for reading user input

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { //entry point of program

        System.out.println();
        System.out.println("===Clothing Store Management System==="); // Welcome message
        System.out.println();
        //Description
        System.out.println("This program's purposes are to:");
        System.out.println("Record and store, manage all data about clothing store such as:");
        System.out.println("-Clothes inventory: items, sizes, brands");
        System.out.println("-Customers and employee information");
        System.out.println("-Orders information");
        System.out.println();
        System.out.println("Name: Kira");
        System.out.println("Course: IT-2505");
        System.out.println();
        System.out.println("Here I will add and test encapsulation, validation and console menu application");
        System.out.println();

        //Add initial test data so user can see examples

        clothingItems.add(new ClothingItem(1,"Red Christmas Sweater",17750.0,"XL","H&M",80));
        clothingItems.add(new ClothingItem(2,"Green Long Sleeve",9500.0,"S","Tishka",10));
        clothingItems.add(new ClothingItem(3,"Christmas Hat",3000.0,"Universal","CoolChristmasHats",65));
        customers.add(new Customer(1,"Dave","XL",630, "heydave3@gmail.com"));
        customers.add(new Customer(2,"Britney","S",1900, "britneynospears00@gmail.com"));
        orders.add(new Order(1, "Dave", 20750.0, "Completed"));
        orders.add(new Order(2, "Britney", 12500.0, "Pending"));

        //Inventory Loop - continues until user exits

        boolean running = true;
        while (running) {

            displayInventory(); // Show menu options
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // IMPORTANT: consume leftover newline
            switch (choice) {
                case 1:
                    addClothingItem();
                    break;
                case 2:
                    viewAllClothingItems();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    viewAllCustomers();
                    break;
                case 5:
                    addOrder();
                    break;
                case 6:
                    viewAllOrders();
                    break;
                case 0:
                    System.out.println("\n\uD83D\uDC4B Goodbye!");
                    running = false; // Exit loop
                    break;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Wait for user
            }
        }
        scanner.close(); // Clean up
    } // End of main method

    //Display Clothing Items

    private static void displayInventory() {
        System.out.println("========================================");
        System.out.println("    CLOTHING STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println();
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("5. Add Order");
        System.out.println("6. View All Orders");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("========================================");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    //Method to add clothing item

    private static void addClothingItem() {
        System.out.println("\n--- ADD CLOTHING ITEM ---");
        System.out.println();
        int itemId = clothingItems.size()+1;

        // Ask for each field

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine(); // Read string
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble(); // Read double
        scanner.nextLine(); // Consume newline
        System.out.print("Enter item size: ");
        String size = scanner.nextLine();
        System.out.print("Enter item brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create new object with user's data

        ClothingItem item = new ClothingItem(itemId, itemName, price, size, brand, quantity);

        // Add to ArrayList

        clothingItems.add(item);
        System.out.println("\n ✅ Clothing item added successfully!");
    }

    //Method to view all clothing items

    private static void viewAllClothingItems() {
        System.out.println("\n========================================");
        System.out.println("           ALL CLOTHING ITEMS");
        System.out.println("========================================");

        // Check if list is empty

        if (clothingItems.isEmpty()) {
            System.out.println("❓ No clothing items found.");
            return; // Exit method early
        }

        //Total number of clothing items

        System.out.println();
        System.out.println("\uD83C\uDF1F Total items: " + clothingItems.size());
        System.out.println();

        // Loop through all items

        for (int i = 0; i < clothingItems.size(); i++) {
            ClothingItem item = clothingItems.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + item.getItemName() +
                    " - " + item.getItemPrice());
            System.out.println("   Size: " + item.getItemSize());
            System.out.println("   Brand: " + item.getItemBrand());
            System.out.println("   Available: " +
                    (item.isInStock() ? "✅ Yes" : "❌ No") + " (" + item.getItemQuantity() + ")");
            if (item.isPremium()) {
                System.out.println("   \uD83D\uDC8E Premium Item");
            }
            System.out.println();
        }
    }

    //Method to add customers

    private static void addCustomer() {
        System.out.println("\n--- ADD CUSTOMER ---");
        System.out.println();
        int customerId = customers.size()+1;

        // Ask for each field

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine(); // Read string
        System.out.print("Enter preferred size: ");
        String preferredSize = scanner.nextLine(); // Read double
        System.out.print("Enter amount of customer points: ");
        int points = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        // Create new object with user's data

        Customer customer = new Customer(customerId, customerName, preferredSize, points, email);

        // Add to ArrayList

        customers.add(customer);
        System.out.println("\n✅ Customer added successfully!");
    }

    //Method to view all customers

    private static void viewAllCustomers() {
        System.out.println("\n========================================");
        System.out.println("            ALL CUSTOMERS");
        System.out.println("========================================");
        System.out.println();

        // Check if list is empty

        if (customers.isEmpty()) {
            System.out.println("❓ No customers found.");
            return; // Exit method early
        }

        //Total number of customers

        System.out.println();
        System.out.println("\uD83C\uDF1F Total customers: " + customers.size());
        System.out.println();

        // Loop through all customers

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + customer.getCustomerName());
            System.out.println("   Preferred Size: " + customer.getPreferredSize());
            System.out.println("   Points: " + customer.getCustomerPoints());
            System.out.println("   Email: " + customer.getCustomerEmail());
            if (customer.isVIP()) {
                System.out.println("   ⭐ VIP customer");
            }
            System.out.println();
        }
    }

    //Method to add orders

    private static void addOrder() {
        System.out.println("\n--- ADD ORDER ---");
        System.out.println();
        int orderId = orders.size()+1;

        // Ask for each field

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine(); // Read string
        System.out.print("Enter total price: ");
        double total = scanner.nextDouble(); // Read double
        scanner.nextLine(); // Consume newline
        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        // Create new object with user's data

        Order order = new Order(orderId, customerName, total, status);

        // Add to ArrayList

        orders.add(order);
        System.out.println("\n ✅ Order added successfully!");
    }

    //Method to view all orders

    private static void viewAllOrders() {
        System.out.println("\n========================================");
        System.out.println("               ALL ORDERS");
        System.out.println("========================================");

        // Check if list is empty

        if (orders.isEmpty()) {
            System.out.println("❓ No orders found.");
            return; // Exit method early
        }

        //Total number of orders

        System.out.println();
        System.out.println("\uD83C\uDF1F Total orders: " + orders.size());
        System.out.println();

        // Loop through all orders

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + order.getCustomerName());
            System.out.println("   Total price: " + order.getTotal());
            if (order.isPending()) {
                System.out.println("   Status: ⏳ Pending");
            }
            else if(Objects.equals(order.getStatus(), "Completed")){
                System.out.println("   Status: ✅ Completed");
            }
            else if(Objects.equals(order.getStatus(), "Cancelled")){
                System.out.println("   Status: ❌ Cancelled");
            }
            else{
                System.out.println("   Status: ❓ Unknown");
            }
            System.out.println();
        }
    }

}

