package FridgeObjects;

public class Meat extends FoodEntry {

    public Meat(String name) {
        super(name);
    }
    //REQUIRES: valid foodentry
    //MODIFIES: foodEntries , this
    //EFFECTS: sets this item's expiry date and adds it to list of food items
//    @Override
//    public void addItem(FoodEntry f) {
//        f.setExpiryDate();
//        try {
//            addFoodEntry(f);
//        } catch (TooManyFoodEntriesException e) {
//            e.printStackTrace();
//        }
//    }
}
