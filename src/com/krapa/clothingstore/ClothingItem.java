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
        this.itemId = itemId;
    }
    public void setItemName(String itemName) {
        if(itemName != null && !itemName.trim().isEmpty()){this.itemName = itemName;}
        else{
            System.out.println("Warning: Name cannot be empty! Setting to null.");
        }
    }
    public void setItemPrice(double itemPrice) {
        if(itemPrice >= 0){this.itemPrice = itemPrice;}
        else{
            System.out.println("Warning: Price cannot be negative! Setting to 0.");
            this.itemPrice = 0;
        }
    }
    public void setItemSize(String itemSize) {
        if(itemSize != null && !itemSize.trim().isEmpty()){this.itemSize = itemSize;}
        else{
            System.out.println("Warning: Size cannot be empty! Setting to null.");
        }
    }
    public void setItemBrand(String itemBrand) {
        if(itemBrand != null && !itemBrand.trim().isEmpty()){this.itemBrand = itemBrand;}
        else {
            System.out.println("Warning: Brand cannot be empty! Setting to null.");
        }
    }
    public void setItemQuantity(int itemQuantity) {
        if(itemQuantity >= 0){this.itemQuantity = itemQuantity;}
        else{
            System.out.println("Warning: Quantity cannot be negative! Setting to 0.");
            this.itemQuantity = 0;
        }
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

    public void printInfo() {
        System.out.println(itemName + " is general clothing item.");
    }
    public String getItemType() {
        return "General clothing item";
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
