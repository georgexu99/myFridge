package test;

import FridgeObjects.Dairy;
import FridgeObjects.FoodEntry;
import FridgeObjects.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMyFridge {
    private List<FoodEntry> foodEntries;

    @BeforeEach
    public void runBefore() {
        foodEntries = new ArrayList<>();
    }

    @Test
    public void testAddFridgeItemsOneMeat() {

        String scannerInputName = "meat";
        Meat meat = new Meat(scannerInputName);
        assertEquals(meat, meat.getName());

        foodEntries.add(meat);
        assertEquals(foodEntries.size(), 1);
    }

    @Test

    public void testAddFridgeItemsOneDairy() {
        String scannerInputName = "dairy";
        Dairy dairy = new Dairy(scannerInputName);
        assertEquals(dairy, dairy.getName());

        foodEntries.add(dairy);
        assertEquals(foodEntries.size(), 1);
    }

    @Test
    public void testAddFridgeItemsMeatAndDairy() {
        for (int i = 0; i < 20; i++) {
            foodEntries.add(new Dairy(String.valueOf(i)));
        }
        for (int i = 0; i < 20; i++) {
            foodEntries.add(new Meat(String.valueOf(i)));
        }

        for (int i = 0; i < 40; i++) {
            assertEquals(foodEntries.size(), 40);
        }
    }


    @Test
    public void testFridgeItemsNumber() {
        assertEquals(0, foodEntries.size());

        Meat meatItem = new Meat("0");
        Meat meatItem1 = new Meat("1");
        Meat meatItem2 = new Meat("2");
        Meat meatItem3 = new Meat("3");
        Meat meatItem4 = new Meat("4");
        Meat meatItem5 = new Meat("5");

        foodEntries.add(meatItem);
        foodEntries.add(meatItem1);
        foodEntries.add(meatItem2);
        foodEntries.add(meatItem3);
        foodEntries.add(meatItem4);
        foodEntries.add(meatItem5);

        assertEquals(6, foodEntries.size());
    }


}



