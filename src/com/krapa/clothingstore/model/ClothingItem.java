package com.krapa.clothingstore.model;

//A clothing piece, contains all necessary variables, constructors, getters, setters, logic methods

public abstract class ClothingItem{
    protected int itemId;
    protected String itemName;
    protected double itemPrice; //Unspecified currency
    protected String itemSize;
    protected String itemBrand;
    protected int itemQuantity;

    //Constructor
    //Assigning values

    public ClothingItem(int itemId, String itemName, double itemPrice, String itemSize, String itemBrand, int itemQuantity) {
        this.itemId = itemId;
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemSize(itemSize);
        setItemBrand(itemBrand);
        setItemQuantity(itemQuantity);
    }

    //not full constructor (only few variables)
//    public ClothingItem(String itemName, double itemPrice) {
//        this.itemName = itemName;
//        this.itemPrice = itemPrice;
//    }

    //Default Constructor

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
    //Setting values (with validation)

    public void setItemId(int itemId) {
        if(itemId < 0){
            throw new IllegalArgumentException("Item ID cannot be negative!");
        }
        this.itemId = itemId;
    }
    public void setItemName(String itemName) {
        if(itemName == null || itemName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.itemName = itemName;
    }
    public void setItemPrice(double itemPrice) {
        if(itemPrice < 0){
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.itemPrice = itemPrice;
    }
    public void setItemSize(String itemSize) {
        if(itemSize == null || itemSize.trim().isEmpty())
        {
            throw new IllegalArgumentException("Size cannot be empty!");
        }
        this.itemSize = itemSize;
    }
    public void setItemBrand(String itemBrand) {
        if(itemBrand == null || itemBrand.trim().isEmpty())
        {
            throw new IllegalArgumentException("Brand cannot be empty!");
        }
        this.itemBrand = itemBrand;
    }
    public void setItemQuantity(int itemQuantity) {
        if(itemQuantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
        this.itemQuantity = itemQuantity;
    }

    //Methods with logic
    //Adds additional logic methods

    public void applyDiscount(double percent){
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        else {
            double discount = itemPrice * (percent / 100);
            this.itemPrice = itemPrice - discount;
        }
    }
    public boolean isPremium(){
        return itemPrice >= 15000;
    }
    public boolean isInStock(){
        return itemQuantity > 0;
    }

    //Abstract method for getting item info
    public abstract void printInfo();

    //Abstract method for getting item type
    public abstract String getItemType();

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
