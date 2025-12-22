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
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName) {
        if(customerName != null && !customerName.trim().isEmpty()){this.customerName = customerName;}
        else {
            System.out.println("Warning: Name cannot be empty! Setting to null.");
        }
    }
    public void setTotal(double total) {
        if(total >= 0){this.total = total;}
        else {
            System.out.println("Warning: Total price cannot be negative! Setting to 0.");
        }
    }
    public void setStatus(String status) {
        if(status != null && !status.trim().isEmpty()){this.status = status;}
        else {
            System.out.println("Warning: Status cannot be empty! Setting to null.");
        }
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
