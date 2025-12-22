package com.krapa.clothingstore;

//import java.security.Principal; //Authentication, that won't be used for now

public class Main2 { // main class
    public static void main(String[] args){
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
        System.out.println("Here I will add and test getters, setters and additional logical methods");
        System.out.println();

        //ClothingItem objects

        ClothingItem cl1= new ClothingItem( 1,"Black T-Shirt",5500.0,"L","Fila",100);
        ClothingItem cl2= new ClothingItem( 2,"Gray Sweater",25500.0,"M","Moncler",25);
        ClothingItem cl3 = new ClothingItem();//default
//        cl3.setItemBrand("Black T-Shirt"); //sets item brand (just an example of setters)

        //Order objects

        Order ord1=new Order(1,"Alex",25500.0,"Pending");
        Order ord2=new Order(2,"Bob",5500.0,"Pending");

        //Customer objects

        Customer cus1=new Customer(1,"Max","L",1150, "maxcustom@gmail.com");
        Customer cus2=new Customer(2,"Karen","M",840, "karen98@gmail.com");

        //Displaying objects

        System.out.println("---CLOTHING ITEMS---");

        System.out.println();
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println();

        System.out.println("---ORDERS---");

        System.out.println();
        System.out.println(ord1);
        System.out.println(ord2);
        System.out.println();

        System.out.println("---CUSTOMERS---");

        System.out.println();
        System.out.println(cus1);
        System.out.println(cus2);
        System.out.println();

        //Testing getters

        System.out.println("---TESTING GETTERS---");

        System.out.println();
        System.out.println("Item 2 ID: "+cl2.getItemId());
        System.out.println("Item 1 name: "+cl1.getItemName());
        System.out.println("Item 1 price: "+cl1.getItemPrice());
        System.out.println("Order 1 status: "+ord1.getStatus());
        System.out.println("Order 2 customer name: "+ord2.getCustomerName());
        System.out.println("Customer 2 points: "+cus2.getCustomerPoints());
        System.out.println("Customer 2 name: "+cus2.getCustomerName());
        System.out.println("Customer 1 preferred size: "+cus1.getPreferredSize());
        System.out.println("Customer 1 email: "+cus1.getCustomerEmail());

        System.out.println();

        //Testing setters

        System.out.println("---TESTING SETTERS---");

        System.out.println();
        System.out.println("Updating clothing item 1");
        cl1.setItemName("Black T-Shirt (NEW COLLECTION)");
        cl1.setItemPrice(7000.0);
        cl1.setItemSize("XL");
        cl1.setItemQuantity(46);
        System.out.println("Updated: "+cl1);
        System.out.println();

        System.out.println("Adding clothing item 3");
        cl3.setItemId(3);
        cl3.setItemName("Winter Jeans (NEW COLLECTION)");
        cl3.setItemPrice(30000.0);
        cl3.setItemSize("M");
        cl3.setItemBrand("Levi's");
        cl3.setItemQuantity(15);
        System.out.println("New item: "+cl3);
        System.out.println();

        System.out.println("Updating order 1 details");
        ord1.setCustomerName("Kevin");
        ord1.setTotal(20000.0);
        System.out.println("Updated: "+ord1);
        System.out.println();

        System.out.println("Updating customer 2 details");
        cus2.setCustomerEmail("karen998@gmail.com");
        cus2.setPreferredSize("L");
        cus2.setPoints(850);
        System.out.println("Updated: "+cus2);
        System.out.println();

        //Testing logic methods

        //ClothingItem

        System.out.println("---TESTING CLOTHINGITEM METHODS");

        System.out.println();
        System.out.println("Premium item starts from 15000");
        System.out.println();
        System.out.println(cl1.getItemName()+" is premium: "+cl1.isPremium());
        System.out.println(cl2.getItemName()+" is premium: "+cl2.isPremium());
        System.out.println(cl3.getItemName()+" is premium: "+cl3.isPremium());
        System.out.println();
        System.out.println(cl2.getItemName()+" in stock: "+cl2.isInStock());
        System.out.println("Applying 25% discount to "+cl2.getItemName());
        cl2.applyDiscount(25);
        System.out.println("New price: "+cl2.getItemPrice());
        System.out.println();

        //Customer

        System.out.println("---TESTING CUSTOMER METHODS");

        System.out.println();
        System.out.println("You need 1000 points to become a VIP");
        System.out.println();
        System.out.println(cus1.getCustomerName()+" is VIP: "+cus1.isVIP()+" ("+cus1.getCustomerPoints()+" points)");
        System.out.println(cus2.getCustomerName()+" is VIP: "+cus2.isVIP()+" ("+cus2.getCustomerPoints()+" points)");
        System.out.println();
        System.out.println(cus1.getCustomerName()+" has gifted 200 points to "+cus2.getCustomerName());
        System.out.println();
        cus1.addPoints(-200);
        cus2.addPoints(200);
        System.out.println(cus1.getCustomerName()+" is VIP: "+cus1.isVIP()+" ("+cus1.getCustomerPoints()+" points)");
        System.out.println(cus2.getCustomerName()+" is VIP: "+cus2.isVIP()+" ("+cus2.getCustomerPoints()+" points)");
        System.out.println();

        //Order

        System.out.println("---TESTING ORDER METHODS");

        System.out.println();
        System.out.println("Order "+ord1.getOrderId()+" is pending: "+ord1.isPending());
        System.out.println("Status: "+ord1.getStatus());
        System.out.println();
        System.out.println("Order "+ord2.getOrderId()+" is pending: "+ord2.isPending());
        System.out.println("Status: "+ord2.getStatus());
        ord2.cancel();
        System.out.println("Order "+ord2.getOrderId()+" is pending: "+ord2.isPending());
        System.out.println("Status: "+ord2.getStatus());
        System.out.println();
        System.out.println("Order "+ord1.getOrderId()+" total: "+ord1.getTotal());
        System.out.println("Adding in order "+ord1.getOrderId());
        ord1.addAmount(5500.0);
        ord1.addAmount(3000.0);
        System.out.println("Order "+ord1.getOrderId()+" total: "+ord1.getTotal());
        ord1.complete();
        System.out.println("Order "+ord1.getOrderId()+" is pending: "+ord1.isPending());
        System.out.println("Status: "+ord1.getStatus());
        System.out.println();

        //Final summary

        System.out.println("---FINAL STATE---");
        System.out.println();
        System.out.println("Clothing Items:");
        System.out.println();
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println();
        System.out.println("Customers:");
        System.out.println();
        System.out.println(cus1);
        System.out.println(cus2);
        System.out.println();
        System.out.println("Orders:");
        System.out.println();
        System.out.println(ord1);
        System.out.println(ord2);

        System.out.println("\n===Program Complete==="); // \n = System.out.println();
    }
}