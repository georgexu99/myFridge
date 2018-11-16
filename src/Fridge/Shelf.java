package Fridge;

import FridgeObjects.FoodEntry;
import Observer.FridgeObserver;

import java.util.ArrayList;
import java.util.List;

public class Shelf implements FridgeObserver {
    List<String> foodList= new ArrayList<>();


    public void addFoodItem(FoodEntry f){
        if(!foodList.contains(f.getName())){
            foodList.add(f.getName());
            f.addToShelf(f, this);
        }
    }
    public void removeFoodItem(FoodEntry f){
        if (foodList.contains(f.getName())){
            foodList.remove(f.getName());
            f.removeFromShelf(f, this);
        }
    }

    @Override
    public void update(MyFridge myfridge) {
        for(FoodEntry f: myfridge.getFoodEntries()){
            if(!foodList.contains(f.getName())){
                addFoodItem(f);
                System.out.println(f.getName()+" added.");
            }
        }
    }
}
