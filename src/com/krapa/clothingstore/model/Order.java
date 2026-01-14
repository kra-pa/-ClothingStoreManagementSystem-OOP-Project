package com.krapa.clothingstore.model;

//Information about an order (like in ClothingItem)

import java.util.Objects;

public class Order{
    private int orderId;
    private String customerName;
    private double total; //cost
    private String status;

    //Constructor

    public Order(int orderId, String customerName, double total, String status){
        this.orderId = orderId;
        setCustomerName(customerName);
        setTotal(total);
        setStatus(status);
    }

    //Default Constructor

    public Order() {

    }

    //Getters

    public int getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotal() {
        return total;
    }
    public String getStatus() {
        return status;
    }

    //Setters

    public void setOrderId(int orderId) {
        if(orderId < 0){
            throw new IllegalArgumentException("Order ID cannot be negative!");
        }
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.customerName = customerName;
    }
    public void setTotal(double total) {
        if(total < 0){
            throw new IllegalArgumentException("Total price cannot be negative!");
        }
        this.total = total;
    }
    public void setStatus(String status) {
        if(status == null || status.trim().isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty!");
        }
        this.status = status;
    }

    //Methods with logic

    public boolean isPending(){
        return Objects.equals(status, "Pending");
    }
    public void addAmount(double amount){
        this.total+=amount;
    }
    public void complete(){
        this.status = "Completed";
    }
    public void cancel(){
        this.status = "Cancelled";
    }

    //Override

    @Override public String toString() {
        return "Order{orderId="+orderId+", " +
                "customerName='" + customerName +"', " +
                "total="+total+", " +
                "status="+status+"}";
    }
}
