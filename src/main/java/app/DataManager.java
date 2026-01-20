package app;

import java.util.ArrayList;

import enums.ShoeCategory;

public class DataManager {

    public static ArrayList<ShoeProductModel> allShoes = new ArrayList<>();

    public static void testShoes() {
        if (allShoes.isEmpty()) { // lai neradas x2 viss xd shouout stackoverflow
            allShoes.add(new ShoeProductModel("Nike Air", ShoeCategory.SNEAKERS, 120.0, 10, 42, "White", "Leather", "NIKE-01"));
            allShoes.add(new ShoeProductModel("Timberland", ShoeCategory.BOOTS, 190.0, 5, 44, "Brown", "Suede", "TIMB-02"));
            allShoes.add(new ShoeProductModel("Adidas Run", ShoeCategory.SNEAKERS, 110.0, 15, 43, "Black", "Mesh", "ADI-03"));
        }
    }
}