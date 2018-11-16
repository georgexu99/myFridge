package ui;


import Exceptions.TooManyFoodEntriesException;
import Fridge.MyFridge;
import Fridge.SaveLoad;
import Fridge.WebRequester;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main extends JFrame{


    public static void main (String[] args) throws IOException, TooManyFoodEntriesException {
        WebRequester wr = new WebRequester();
        wr.currentTemperature();
         MyFridge fridge = new MyFridge();
//         fridge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         fridge.setSize(600,600);
//         fridge.setVisible(true);
         Gui gui = new Gui(fridge);
         SaveLoad saveLoad = new SaveLoad(fridge);
         saveLoad.load();
         gui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure(saveLoad, gui);
            }
        });
         gui.setSize(600,600);
         gui.setVisible(true);


         //fridge.load();
         //fridge.addFridgeItems();
//         try {
//             fridge.listExpiredFridgeItems();
//         } catch (Exception e){
//             e.printStackTrace();
//         }
         //fridge.save();

    }
    public static void exitProcedure(SaveLoad saveLoad, Gui gui){
        try {
            saveLoad.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui.dispose();
        System.exit(0);
    }
}
