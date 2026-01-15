package com.krapa.clothingstore.model;

//Information about a customer (like in ClothingItem)

import com.krapa.clothingstore.interfaces.DiscountAvailable;

public class Customer implements DiscountAvailable {
    private int  customerId;
    private String customerName;
    private String preferredSize;
    private int points;
    private String customerEmail;

    //Constructor

    public Customer(int customerId, String customerName, String preferredSize, int points, String customerEmail) {
        this.customerId = customerId;
        setCustomerName(customerName);
        setPreferredSize(preferredSize);
        setPoints(points);
        setCustomerEmail(customerEmail);
    }

    //Default Constructor

    public Customer() {

    }

    //Getters

    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getPreferredSize() {
        return preferredSize;
    }
    public int getCustomerPoints() {
        return  points;
    }
    public String getCustomerEmail() {return customerEmail;}

    //Setters

    public void setCustomerId(int customerId) {
        if (customerId < 0){
            throw new IllegalArgumentException("Customer ID cannot be negative!");
        }
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.customerName = customerName;
    }
    public void setPreferredSize(String preferredSize) {
        if(preferredSize == null || preferredSize.trim().isEmpty()){
            throw new IllegalArgumentException("Preferred size cannot be empty!");
        }
        this.preferredSize = preferredSize;
    }
    public void setPoints(int points) {
        if(points < 0){
            throw new IllegalArgumentException("Points cannot be negative!");
        }
        this.points = points;
    }
    public void setCustomerEmail(String customerEmail) {
        if(customerEmail == null || customerEmail.trim().isEmpty() || !customerEmail.contains("@")){
            throw new IllegalArgumentException("Customer email cannot be empty and must contain @!");
        }
        this.customerEmail = customerEmail;
    }

    //Methods with logic

    public void addPoints(int newPoints){
        this.points += newPoints;
    }

    //Interface override methods

    @Override
    public boolean isVIP() {
        return points >= 1000;
    }

    //Discount for VIP: 15%

    @Override
    public double getDiscount() {
        if (isVIP()) {
            return 0.15;
        }
        else{
            return 0;
        }
    }

    //Override

    @Override public String toString() {
        return "Customer{customerId="+customerId+", " +
                "customerName='" + customerName +"', " +
                "preferredSize='"+preferredSize+"', " +
                "points="+points+", "+
                "customerEmail='"+customerEmail+"'}";
    }
}

