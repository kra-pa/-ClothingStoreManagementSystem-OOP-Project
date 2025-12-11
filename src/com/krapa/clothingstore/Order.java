package com.krapa.clothingstore;

//Information about an order (like in ClothingItem)

public class Order {
    private int orderId;
    private String customerName;
    private int total; //cost
    private String status;

    //Constructor

    public Order(int orderId, String customerName, int total, String status){
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
    public int getTotal() {
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
    public void setTotal(int total) {
        this.total = total;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //Methods with logic

    public void complete(){
        this.status = "Order Completed";
    }
    public void cancel(){
        this.status = "Order Cancelled";
    }

    //Override

    @Override public String toString() {
        return "Order{orderId='"+orderId+"'," +
                "customerName=" + customerName +"," +
                " total='"+total+"', " +
                "status="+status+"}";
    }
}
