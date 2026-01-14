package com.krapa.clothingstore.model;

public class Pants extends ClothingItem {
    // Additional field specific to Pants
    private String pantsMaterial;
    // Constructor - uses super() to call parent constructor
    public Pants(int itemId, String itemName, double itemPrice, String itemSize, String itemBrand, int itemQuantity, String pantsMaterial) {
        super(itemId, itemName, itemPrice, itemSize, itemBrand, itemQuantity); // MUST BE FIRST!
        setPantsMaterial(pantsMaterial);
    }
    // Getter and Setter for new field
    //Added exception handling
    public String getPantsMaterial() {
        return pantsMaterial;
    }
    public void setPantsMaterial(String pantsMaterial) {
        if (pantsMaterial == null || pantsMaterial.trim().isEmpty()) {
            throw new IllegalArgumentException("Pants material cannot be empty!");
        }
        this.pantsMaterial = pantsMaterial;
    }
    // Override method 1
    @Override
    public void printInfo() {
        System.out.println(itemName + " are made of " + pantsMaterial);
    }
    // Override method 2
    @Override
    public String getItemType() {
        return "Pants";
    }
    // New method specific to Pants
    public boolean isDenim() {
        return pantsMaterial.equalsIgnoreCase("Denim");
    }
    @Override
    public String toString() {
        return super.toString() + " | Pants Material: " + pantsMaterial;
    }
}