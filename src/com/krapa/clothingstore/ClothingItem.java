package com.krapa.clothingstore;

//A clothing piece, contains all necessary variables, constructors, getters, setters, logic methods

public class ClothingItem{
    private int itemId;
    private String itemName;
    private double itemPrice; //Unspecified currency
    private String itemSize;
    private String itemBrand;
    private int itemQuantity;

    //Constructor
    //Assigning values

    public ClothingItem(int itemId, String itemName, double itemPrice, String itemSize, String itemBrand, int itemQuantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSize = itemSize;
        this.itemBrand = itemBrand;
        this.itemQuantity = itemQuantity;
    }

    //not full constructor (only few variables)
//    public ClothingItem(String itemName, double itemPrice) {
//        this.itemName = itemName;
//        this.itemPrice = itemPrice;
//    }

    //Default constructor

    public ClothingItem() {

    }

    //Getters
    //Returning values

    public int getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public String getItemSize() {
        return itemSize;
    }
    public String getItemBrand() {
        return itemBrand;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }

    //Setters
    //Setting values

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    //Methods with logic
    //Adds additional logic methods

    public void applyDiscount(double percent){
        double discount = itemPrice * (percent / 100);
        this.itemPrice=itemPrice-discount;
    }
    public boolean isPremium(){
        return itemPrice >= 15000;
    }
    public boolean isInStock(){
        return itemQuantity > 0;
    }

    //Override
    //Return string with all field values

    @Override public String toString() {
        return "ClothingItem{itemId="+itemId+", "+
                "itemName='"+itemName+"', " +
                "itemPrice=" + itemPrice +", " +
                "itemSize='"+itemSize+"', " +
                "itemBrand='"+itemBrand+"', " +
                "itemQuantity="+itemQuantity+"}";
    }
}
