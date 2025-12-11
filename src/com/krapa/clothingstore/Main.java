package com.krapa.clothingstore;

import java.security.Principal;

public class Main{ // main class
    public static void main(String[] args){
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

        //ClothingItem objects

        ClothingItem cl1= new ClothingItem( 1,"Black T-Shirt",5500.0,"L","Fila",100);
        ClothingItem cl2= new ClothingItem( 2,"Gray Sweater",25500.0,"M","Moncler",25);
        ClothingItem cl3 = new ClothingItem();//default
        cl3.setItemBrand("Black T-Shirt");

        //Order objects

        Order ord1=new Order(1,"Alex",25500,"Pending");
        Order ord2=new Order(2,"Bob",5500,"Completed");

        //Customer objects

        Customer cus1=new Customer(1,"Max","L",500);
        Customer cus2=new Customer(2,"Karen","M",2500);

        //Displaying objects

        System.out.println("---CLOTHING ITEMS---");
        System.out.println(cl1);
        System.out.println(cl2);
//        System.out.println(cl3);
        System.out.println();
        System.out.println("---ORDERS---");
        System.out.println(ord1);
        System.out.println(ord2);
        System.out.println();
        System.out.println("---CUSTOMERS---");
        System.out.println(cus1);
        System.out.println(cus2);
        System.out.println();

        //Testing getters

        System.out.println("---TESTING GETTERS---");

        System.out.println("Item 1 ID: "+cl1.getItemId());
        System.out.println("Item 1 price: "+cl1.getItemPrice());
        System.out.println("Order 1 status: "+ord1.getOrderId());
        System.out.println("Customer 1 points: "+cus1.getCustomerPoints());
    }
}