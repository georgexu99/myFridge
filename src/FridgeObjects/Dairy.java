package FridgeObjects;

public class Dairy extends FoodEntry {

    public Dairy(String name) {
        super(name);



    }
    //REQUIRES: valid foodentry
    //MODIFIES: foodentries , this
    //EFFECTS: sets this item's expiry date and adds it to list of food items
//    @Override
//    public void addItem(FoodEntry f){
//        f.setExpiryDate();
//        try {
//            addFoodEntry(f);
//        } catch (TooManyFoodEntriesException e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("throw some food out");
//        }


 //   }
}

