package com.krapa.clothingstore.main;
import java.sql.Connection;
import java.sql.DriverManager;
import com.krapa.clothingstore.clothes.ClothingItemStock;
import com.krapa.clothingstore.clothes.Clothes;
public class Main {
    public static void main(String[] args) {
        Clothes clothes = new ClothingItemStock();
        clothes.run();
    }
}
