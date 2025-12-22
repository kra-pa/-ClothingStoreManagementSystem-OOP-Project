package com.krapa.clothingstore;

//Information about a customer (like in ClothingItem)

public class Customer {
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
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        if(customerName != null && !customerName.trim().isEmpty()){this.customerName = customerName;}
        else {
            System.out.println("Warning: Name cannot be empty! Setting to null.");
        }
    }
    public void setPreferredSize(String preferredSize) {
        if(preferredSize != null && !preferredSize.trim().isEmpty()){this.preferredSize = preferredSize;}
        else {
            System.out.println("Warning: Preferred size cannot be empty! Setting to null.");
        }
    }
    public void setPoints(int points) {
        if(points >= 0){this.points = points;}
        else{
            System.out.println("Warning: Points cannot be negative! Setting to 0.");
            this.points = 0;
        }
    }
    public void setCustomerEmail(String customerEmail) {
        if(customerEmail == null || customerEmail.trim().isEmpty()){System.out.println("Warning: Preferred size cannot be empty! Setting to null.");}
        else if(!customerEmail.contains("@")){System.out.println("Warning: Email must contain @ symbol! Setting to null.");}
        else {
            this.customerEmail = customerEmail;
        }
    }

    //Methods with logic

    public void addPoints(int newpoints){
        this.points += newpoints;
    }
    public boolean isVIP(){
        return points >= 1000;
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

