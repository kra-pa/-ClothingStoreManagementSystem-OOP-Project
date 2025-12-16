package com.krapa.clothingstore;

//Information about an order (like in ClothingItem)

import java.util.Objects;

public class Order {
    private int orderId;
    private String customerName;
    private double total; //cost
    private String status;

    //Constructor

    public Order(int orderId, String customerName, double total, String status){
        this.orderId = orderId;
        this.customerName = customerName;
        this.total = total;
        this.status = status;
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
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //Methods with logic

    public boolean isPending(){
        return Objects.equals(status, "Pending");
    }
    public void addAmount(double amount){
        this.total+=amount;
    }
    public void Complete(){
        this.status = "Completed";
    }
    public void Cancel(){
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
