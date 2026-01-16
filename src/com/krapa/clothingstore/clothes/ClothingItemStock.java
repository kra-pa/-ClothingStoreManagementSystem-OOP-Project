package com.krapa.clothingstore.clothes;

import com.krapa.clothingstore.model.*;

import java.util.Objects;
import java.util.ArrayList; //Allows us to use ArrayList
import java.util.Scanner; //Allows us to read user input

public class ClothingItemStock implements Clothes { // main class

    //Arrays. These ArrayLists store all our objects
    //'static' means they belong to the class, not individual objects
    //'private' keeps them protected

    //private static ArrayList<ClothingItem> clothingItems = new ArrayList<>();
    private ArrayList<ClothingItem> allClothingItems;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private Scanner scanner;

    //Scanner for reading user input

//    private static Scanner scanner = new Scanner(System.in);

    public ClothingItemStock() {

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
        System.out.println("Console menu application");
        System.out.println();

        this.allClothingItems = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        allClothingItems.add(new Shirt(1, "Black Polo Shirt", 12000.0, "M", "Zara", 20, "Long Sleeve"));
        allClothingItems.add(new Pants(2, "Blue Jeans", 18000.0, "L", "Levi's", 15, "Denim"));
        allClothingItems.add(new Hat(3, "White Fedora", 14000.0, "Universal", "Supreme", 20, "Fedora"));

        customers.add(new Customer(1, "Dave", "XL", 630, "heydave3@gmail.com"));
        customers.add(new Customer(2, "Britney", "S", 1900, "britneynospears00@gmail.com"));

        orders.add(new Order(1, "Dave", 20750.0, "Completed"));
        orders.add(new Order(2, "Britney", 12500.0, "Pending"));
    }

    //Display clothing items

    @Override
    public void displayInventory() {
        System.out.println("========================================");
        System.out.println("    CLOTHING STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println();
        System.out.println("1. View All Clothing");
        System.out.println("2. View Shirts Only");
        System.out.println("3. View Pants Only");
        System.out.println("4. View Hats Only");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.println("6. Add Customer");
        System.out.println("7. View All customers");
        System.out.println("8. Add Order");
        System.out.println("9. View All Orders");
        System.out.println("10. Add Shirt");
        System.out.println("11. Add Pants");
        System.out.println("12. Add Hat");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("========================================");
        System.out.println();
        System.out.print("Enter your choice: ");
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
                        viewShirtsOnly();
                        break;
                    case 3:
                        viewPantsOnly();
                        break;
                    case 4:
                        viewHatsOnly();
                        break;
                    case 5:
                        demonstratePolymorphism();
                        break;
                    case 6:
                        addCustomer();
                        break;
                    case 7:
                        viewAllCustomers();
                        break;
                    case 8:
                        addOrder();
                        break;
                    case 9:
                        viewAllOrders();
                        break;
                    case 10:
                        addShirt();
                        break;
                    case 11:
                        addPants();
                        break;
                    case 12:
                        addHat();
                        break;
                    case 0:
                        System.out.println("\n\uD83D\uDC4B Goodbye!");
                        running = false; // Exit loop
                        break;
                    default:
                        System.out.println("\n❌ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    } // End of main method

    //Method to add customers

    private void addCustomer() {
        System.out.println("\n--- ADD CUSTOMER ---");
        System.out.println();
        int customerId = customers.size() + 1;

        // Ask for each field

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine(); // Read string
        System.out.print("Enter preferred size: ");
        String preferredSize = scanner.nextLine();
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

    private void viewAllCustomers() {
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
            Customer customer = customers.get(i); // Get customer at index i
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

    private void addOrder() {
        System.out.println("\n--- ADD ORDER ---");
        System.out.println();
        int orderId = orders.size() + 1;

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

    private void viewAllOrders() {
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
            Order order = orders.get(i); // Get order at index i
            System.out.println((i + 1) + ". " + order.getCustomerName());
            System.out.println("   Total price: " + order.getTotal());
            if (order.isPending()) {
                System.out.println("   Status: ⏳ Pending");
            } else if (Objects.equals(order.getStatus(), "Completed")) {
                System.out.println("   Status: ✅ Completed");
            } else if (Objects.equals(order.getStatus(), "Cancelled")) {
                System.out.println("   Status: ❌ Cancelled");
            } else {
                System.out.println("   Status: ❓ Unknown");
            }
            System.out.println();
        }
    }

    // Adds Shirt object

    private void addShirt() {

        System.out.println("\n--- ADD SHIRT ---");
        System.out.println();

        int newId = allClothingItems.size() + 1;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter shirt type: ");
        String type = scanner.nextLine();

        // Create Shirt but store as ClothingItem (polymorphism!)
        ClothingItem item = new Shirt(newId, name, price, size, brand, quantity, type);

        allClothingItems.add(item);

        System.out.println("\n✅ Shirt added successfully!");
    }

    // Adds Pants object

    private void addPants() {

        System.out.println("\n--- ADD PANTS ---");
        System.out.println();

        int newId = allClothingItems.size() + 1;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter pants material: ");
        String material = scanner.nextLine();

        ClothingItem item = new Pants(newId, name, price, size, brand, quantity, material);

        allClothingItems.add(item);

        System.out.println("\n✅ Pants added successfully!");
    }

    // Adds Hat object

    private void addHat() {

        System.out.println("\n--- ADD HAT ---");
        System.out.println();

        int newId = allClothingItems.size() + 1;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter hat's type: ");
        String type = scanner.nextLine();

        ClothingItem item = new Hat(newId, name, price, size, brand, quantity, type);

        allClothingItems.add(item);

        System.out.println("\n✅ Hat added successfully!");
    }

    // Shows all clothing items
    private void viewAllClothingItems() {

        System.out.println("\n========================================");
        System.out.println("           ALL CLOTHING ITEMS");
        System.out.println("========================================");
        System.out.println();

        if (allClothingItems.isEmpty()) {
            System.out.println("❓ No clothing items found.");
            return;
        }

        System.out.println("Total items: " + allClothingItems.size());
        System.out.println();

        for (int i = 0; i < allClothingItems.size(); i++) {

            ClothingItem item = allClothingItems.get(i);

            System.out.println((i + 1) + ". [" + item.getItemType() + "] " + item);

            if (item instanceof Hat) {
                Hat hat = (Hat) item;
                if (hat.isUniversalSize()) {
                    System.out.println("   (Universal Size Hat)");
                }
                System.out.println();
            }
        }
    }
        //Method to demonstrate polymorphism

        private void demonstratePolymorphism () {

            System.out.println("\n========================================");
            System.out.println("       POLYMORPHISM DEMONSTRATION");
            System.out.println("========================================");
            System.out.println();

            System.out.println("Calling printInfo() on all clothing items:");
            System.out.println();

            // Loop shows polymorphism

            for (ClothingItem item : allClothingItems) {
                item.printInfo(); // Polymorphism: Same method, different behavior
            }

            System.out.println();
            System.out.println("✨ Notice: same method name, different behavior!");
            System.out.println("This is POLYMORPHISM in action!");
        }

        //Method to view shirts only

        private void viewShirtsOnly () {

            System.out.println("\n========================================");
            System.out.println("              SHIRTS ONLY");
            System.out.println("========================================");
            System.out.println();

            int count = 0;

            for (ClothingItem item : allClothingItems) {

                if (item instanceof Shirt) {

                    Shirt shirt = (Shirt) item;

                    count++;

                    System.out.println(count + ". Shirt ID: " + shirt.getItemId());
                    System.out.println("   Name: " + shirt.getItemName());
                    System.out.println("   Price: " + shirt.getItemPrice());
                    System.out.println("   Size: " + shirt.getItemSize());
                    System.out.println("   Brand: " + shirt.getItemBrand());
                    System.out.println("   Quantity: " + shirt.getItemQuantity());
                    System.out.println("   Shirt Type: " + shirt.getShirtType());

                    if (shirt.isTShirt()) {
                        System.out.println("   \uD83D\uDC55 T-Shirt Item");
                    }

                    System.out.println();
                }
            }

            if (count == 0) {
                System.out.println("No shirts found.");
            }
        }

        //Method to view pants only

        private void viewPantsOnly () {

            System.out.println("\n========================================");
            System.out.println("               PANTS ONLY");
            System.out.println("========================================");
            System.out.println();

            int count = 0;

            for (ClothingItem item : allClothingItems) {

                if (item instanceof Pants) {

                    Pants pants = (Pants) item;

                    count++;

                    System.out.println(count + ". Pants ID: " + pants.getItemId());
                    System.out.println("   Name: " + pants.getItemName());
                    System.out.println("   Price: " + pants.getItemPrice());
                    System.out.println("   Size: " + pants.getItemSize());
                    System.out.println("   Brand: " + pants.getItemBrand());
                    System.out.println("   Quantity: " + pants.getItemQuantity());
                    System.out.println("   Material: " + pants.getPantsMaterial());

                    if (pants.isDenim()) {
                        System.out.println("   \uD83D\uDC56 Denim Pants");
                    }

                    System.out.println();
                }
            }

            if (count == 0) {
                System.out.println("No pants found.");
            }
        }


        //Method to view hats only

        private void viewHatsOnly () {

            System.out.println("\n========================================");
            System.out.println("               HATS ONLY");
            System.out.println("========================================");
            System.out.println();

            int count = 0;

            for (ClothingItem item : allClothingItems) {

                if (item instanceof Hat) {

                    Hat hat = (Hat) item;

                    count++;

                    System.out.println(count + ". Hat ID: " + hat.getItemId());
                    System.out.println("   Name: " + hat.getItemName());
                    System.out.println("   Price: " + hat.getItemPrice());
                    System.out.println("   Size: " + hat.getItemSize());
                    System.out.println("   Brand: " + hat.getItemBrand());
                    System.out.println("   Quantity: " + hat.getItemQuantity());
                    System.out.println("   Hat Type: " + hat.getHatType());

                    if (hat.isUniversalSize()) {
                        System.out.println("   \uD83C\uDFA9 Universal Size Hat");
                    }

                    System.out.println();
                }
            }

            if (count == 0) {
                System.out.println("No hats found.");
            }
        }
    }