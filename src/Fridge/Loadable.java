package Fridge;

import Exceptions.TooManyFoodEntriesException;
import FridgeObjects.FoodEntry;

import java.io.IOException;

public interface Loadable {
    void load() throws IOException, TooManyFoodEntriesException;
    void loadItem(FoodEntry f);
}
