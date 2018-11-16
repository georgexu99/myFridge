package Fridge;

import FridgeObjects.Dairy;
import FridgeObjects.FoodEntry;
import FridgeObjects.Meat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveLoad implements Loadable, Savable{
    MyFridge myfridge;
    ArrayList<String> partsOfLine;

    public SaveLoad(MyFridge myfridge){
        this.myfridge =myfridge;

    }
    @Override
    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("file.txt"));
        for (String line : lines) {
            partsOfLine = splitOnSpace(line);
            if (partsOfLine.get(0).equals("Meat")) {
                loadItem(new Meat(partsOfLine.get(1)));
                //Meat meat = new Meat(partsOfLine.get(1));
                //meat.manualSetExpiry(partsOfLine.get(2));
                //myfridge.addFoodEntry(meat);
                //foodEntries.add(meat);
            } else if (partsOfLine.get(0).equals("Dairy")) {
                loadItem(new Dairy((partsOfLine.get(1))));
                //dairy.manualSetExpiry(partsOfLine.get(2));
                //myfridge.addFoodEntry(dairy);
                //foodEntries.add(dairy);
            }

        }
    }

    @Override
    public void loadItem(FoodEntry f) {
        f.manualSetExpiry(partsOfLine.get(2));
        myfridge.addFoodEntry(f);

    }

    @Override
    public void save() throws IOException {

        PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
        clearTheFile();
        for (FoodEntry f : myfridge.getFoodEntries()) {
            String str = f.getClass().toString();
            str = str.replaceAll("class FridgeObjects.", "");
            writer.println(str + " " + f.getName() + " " + f.getExpiryDate());
        }
        writer.close();

    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split((" "));
        return new ArrayList<>(Arrays.asList(splits));
    }

    public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("file.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}
