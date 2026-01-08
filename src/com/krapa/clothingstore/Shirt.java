package com.krapa.clothingstore;

public class Shirt extends ClothingItem {
    // Additional field specific to Shirt
    private String shirtType;
    // Constructor - uses super() to call parent constructor
    public Shirt(int itemId, String itemName, double itemPrice, String itemSize, String itemBrand, int itemQuantity, String shirtType) {
        super(itemId, itemName, itemPrice, itemSize, itemBrand, itemQuantity); // MUST BE FIRST!
        this.shirtType = shirtType;
    }
    // Getter and Setter for new field
    public String getShirtType() {
        return shirtType;
    }
    public void setShirtType(String shirtType) {
        this.shirtType = shirtType;
    }
    // Override method 1
    @Override
    public void printInfo() {
        System.out.println(itemName + " has a " + shirtType + " type");
    }
    // Override method 2
    @Override
    public String getItemType() {
        return "Shirt";
    }
    // New method specific to Shirt
    public boolean isTShirt() {
        return shirtType.equalsIgnoreCase("T-Shirt");
    }
    @Override
    public String toString() {
        return super.toString() + " | Shirt Type: " + shirtType;
    }
}