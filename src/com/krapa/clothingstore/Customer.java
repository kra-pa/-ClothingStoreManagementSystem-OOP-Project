package com.krapa.clothingstore;

//Information about a customer (like in ClothingItem)

public class Customer {
    private int  customerId;
    private String customerName;
    private String preferredSize;
    private int points;

    //Constructor

    public Customer(int customerId, String customerName, String preferredSize, int points) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.preferredSize = preferredSize;
        this.points = points;
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

    //Setters

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPreferredSize(String preferredSize) {
        this.preferredSize = preferredSize;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    //Methods with logic

    public void addPoints(int points){
        this.points += points;
    }
    public boolean isVIP(){
        return points >= 1000;
    }

    //Override

    @Override public String toString() {
        return "Customer{customerId='"+customerId+"'," +
                "customerName=" + customerName +"," +
                " preferredSize='"+preferredSize+"', " +
                "points="+points+"}";
    }
}

