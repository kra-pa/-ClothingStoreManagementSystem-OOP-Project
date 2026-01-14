package com.krapa.clothingstore.model;

public class Hat extends ClothingItem {
    // Additional field specific to Hat
    private String hatType;
    // Constructor - uses super() to call parent constructor
    public Hat(int itemId, String itemName, double itemPrice, String itemSize, String itemBrand, int itemQuantity, String hatType) {
        super(itemId, itemName, itemPrice, itemSize, itemBrand, itemQuantity); // MUST BE FIRST!
        setHatType(hatType);
    }
    // Getter and Setter for new field
    //Added exception handling
    public String getHatType() {
        return hatType;
    }
    public void setHatType(String hatType) {
        if (hatType == null || hatType.trim().isEmpty()) {
            throw new IllegalArgumentException("Hat type cannot be empty!");
        }
        this.hatType = hatType;
    }
    // Override method 1
    @Override
    public void printInfo() {
        System.out.println(itemName + " has a " + hatType + " type");
    }
    // Override method 2
    @Override
    public String getItemType() {
        return "Hat";
    }
    // New method specific to Hat
    public boolean isUniversalSize() {
        return getItemSize().equalsIgnoreCase("Universal");
    }
    // New method specific to Hat
    public boolean isFedora() {
        return getHatType().equalsIgnoreCase("Fedora");
    }
    @Override
    public String toString() {
        return super.toString() + " | Hat Type: " + hatType;
    }
}