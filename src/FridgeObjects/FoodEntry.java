package FridgeObjects;

import Fridge.Shelf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public abstract class FoodEntry {
    private String name;
    private String entryDate;
    private String expiryDate;
    private HashMap<String, Shelf> fridgeShelf = new HashMap();



    public FoodEntry(String name) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        this.name= name;
        this.entryDate = today;
        this.expiryDate = today;
    }

//    public void addItem(FoodEntry f){
//        f.setExpiryDate();
//        try {
//            addFoodEntry(f);
//        } catch (TooManyFoodEntriesException e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("throw some food out");
//        }
//    }

    public void addToShelf(FoodEntry f, Shelf s) {
        if (!fridgeShelf.containsKey(f.getName())) {
            fridgeShelf.put(f.getName(), s);
            System.out.println(f.name + " added to shelf");
            s.addFoodItem(f);

        }
    }
    public void removeFromShelf(FoodEntry f, Shelf s){
        if (fridgeShelf.containsKey(f.getName())){
            fridgeShelf.remove(f.getName());
            s.removeFoodItem(f);
        }
    }

    //REQUIRES: String with format yyyyMMDD
    //MODIFIES: this
    //EFFECTS: sets item's expiry date as date with format yyyyMMDD
    public void manualSetExpiry(String s){
        this.expiryDate = s;
    }
    //REQUIRES: valid expiry date
    //EFFECTS: returns item's expiry date yyyyMMDD
    public String getExpiryDate(){
        return this.expiryDate;
    }

    //REQUIRES: expiry to be a valid date
    //MODIFIES: this
    //EFFECTS: sets expiry date for food item
    public void setExpiryDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("set expiry date, yyyyMMdd: ");
        String expiry = sc.nextLine();
        this.expiryDate = expiry;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntry foodEntry = (FoodEntry) o;
        return Objects.equals(name, foodEntry.name) &&
                Objects.equals(entryDate, foodEntry.entryDate) &&
                Objects.equals(expiryDate, foodEntry.expiryDate) &&
                Objects.equals(fridgeShelf, foodEntry.fridgeShelf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, entryDate, expiryDate, fridgeShelf);
    }

    //REQUIRES: expiry and entry dates to be parsable
    //EFFECTS: returns difference between current date and expiry date
    public int getDPD() throws Exception {
        int daysPastDue;

        try {
            Date formattedDate = new SimpleDateFormat("yyyyMMdd").parse(this.expiryDate);
            Date formattedDate2 = new SimpleDateFormat("yyyyMMdd").parse(this.entryDate);

            long difference = formattedDate2.getTime() - formattedDate.getTime();
            daysPastDue = Math.round((difference / (1000 * 60 * 60 * 24)) - 1);

        } catch (Exception e) {
            throw e;
        }
        return daysPastDue;
    }
    //EFFECTS: determines if current date is past expiry date of item
    public boolean expired() throws Exception {
        try {
            return (getDPD() > 0);
        }catch (Exception e){
            throw e;
        }

    }
    //REQUIRES: item has a name
    //EFFECTS: returns item name
    public String getName(){
        return this.name;
    }

}
