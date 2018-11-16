package ui;

import Fridge.MyFridge;
import Fridge.SaveLoad;
import Fridge.Shelf;
import FridgeObjects.Dairy;
import FridgeObjects.Meat;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Gui extends JFrame {
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;

    private JTextField item1;
    private JTextField item2;

    private int meatItems;
    private int dairyItems;


    private boolean playMusic = false;

    private JFXPanel j = new JFXPanel();
    private String uri = new File("bgm.mp3").toURI().toString();
    private MediaPlayer mp = new MediaPlayer(new Media(uri));



    public Gui(MyFridge myfridge) {
        super("MyFridge");
        setLayout(new FlowLayout());
        SaveLoad saveLoad = new SaveLoad(myfridge);

        Icon meat = new ImageIcon(getClass().getResource("/Images/meat.jpg"));
        Icon dairy = new ImageIcon(getClass().getResource("/Images/dairy.jpg"));
        meatItems = myfridge.getMeats();
        dairyItems = myfridge.getDairys();

        b1 = new JButton(("add meat"));
        add(b1);

        b2 = new JButton("You have " + meatItems + " meat items in the fridge.", meat);
        add(b2);

        b3 = new JButton(("add dairy"));
        add(b3);

        b4 = new JButton("You have " + dairyItems + " dairy items in the fridge.", dairy);
        add(b4);

        b5 = new JButton("show expired items");
        add(b5);

//        b6 = new JButton("play background music");
//        add(b6);



        item1 = new JTextField("entry name",10);
        item1.setToolTipText("item name");
        add(item1);

        item2 = new JTextField("YYYYMMDD",10);
        item2.setToolTipText("YYYYMMDD");
        add(item2);

        TheHandler handler = new TheHandler(myfridge);
        b1.addActionListener(handler);
        b3.addActionListener(handler);
        b5.addActionListener(handler);
        item1.addActionListener(handler);
        item2.addActionListener(handler);

        Icon meatIcon = new ImageIcon(getClass().getResource("/Images/meat.jpg"));
        Icon dairyIcon = new ImageIcon(getClass().getResource("/Images/dairy.jpg"));
    }

    private class TheHandler implements ActionListener {
        MyFridge myfridge;

        public TheHandler(MyFridge myfridge){
            this.myfridge = myfridge;

        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == b1) {
                if (!item1.getText().equals("")) {
                    if (!item2.getText().equals("")) {
                        addMeatButton();
                        myfridge.addShelf(new Shelf());
                        myfridge.notifyObservers(myfridge);
                    } else System.out.println("that is not a valid date! yyyyMMdd");
                } else System.out.println("that is not a valid name!");
            } else if (event.getSource() == b3) {
                if (!item1.getText().equals("")) {
                    if (!item2.getText().equals("")) {
                        addDairyButton();
                        myfridge.notifyObservers(myfridge);
                    } else System.out.println("that is not a valid date! yyyyMMdd");
                } else System.out.println("that is not a valid name!");
            } else if (event.getSource() == b5) {
                expiredItemsButton();
//            } else if (event.getSource() == b6) {
//                playMusic = !playMusic;
//                if (playMusic) {
//                    mp.play();
//               } else
//                    mp.stop();
//////
            }

        }
//        public  void music() {
//            AudioPlayer MGP = AudioPlayer.player;
//            AudioStream BGM;
//            AudioData MD;
//            ContinuousAudioDataStream loop = null;
//
//            try {
//                BGM = new AudioStream((new FileInputStream("bgm.mp3")));
//                MD = BGM.getData();
//                loop = new ContinuousAudioDataStream(MD);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            MGP.start(loop);
//        }
//        private void play(){
//            try {
//                JFXPanel j = new JFXPanel();
//                String uri = new File("bgm.mp3").toURI().toString();
//                new MediaPlayer(new Media(uri)).play();
//            }catch (Exception e){
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }


        private void expiredItemsButton() {
            JFrame frame2 = new JFrame("clicked");
            frame2.setVisible(true);
            frame2.setSize(300, 600);
            JPanel panel = new JPanel();
            frame2.add(panel);
            try {
                for (JLabel l: myfridge.listExpiredFridgeItems()){
                    panel.add(l);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void addDairyButton() {
            Dairy dairy = new Dairy(item1.getText());
            dairy.manualSetExpiry(item2.getText());
            myfridge.addFoodEntry(dairy);
        }

        private void addMeatButton() {
            Meat meat = new Meat(item1.getText());
            meat.manualSetExpiry(item2.getText());
            myfridge.addFoodEntry(meat);

            System.out.println(myfridge.getMeats());
            System.out.println(myfridge.getMeats());
        }
    }
}
