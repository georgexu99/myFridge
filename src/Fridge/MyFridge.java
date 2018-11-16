package Fridge;

import FridgeObjects.Dairy;
import FridgeObjects.FoodEntry;
import FridgeObjects.Meat;
import Observer.Subject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyFridge extends Subject {

    private List<FoodEntry> foodEntries = new ArrayList<>();
    private List<Shelf> shelves = new ArrayList<>();

//    private JButton b1;
//    private JButton b2;
//    private JButton b3;
//    private JButton b4;
//    private JButton b5;
//    private JButton b6;
//
//    private JTextField item1;
//    private JTextField item2;

    private int meatItems;
    private int dairyItems;

//    private boolean playMusic = false;
//
//    private JFXPanel j = new JFXPanel();
//    private String uri = new File("bgm.mp3").toURI().toString();
//    private MediaPlayer mp = new MediaPlayer(new Media(uri));


    public MyFridge() {
//        super("MyFridge");
//        setLayout(new FlowLayout());

//        Icon meat = new ImageIcon(getClass().getResource("/Images/meat.jpg"));
//        Icon dairy = new ImageIcon(getClass().getResource("/Images/dairy.jpg"));
        meatItems = getMeats();
        dairyItems = getDairys();

//        b1 = new JButton(("add meat"));
//        add(b1);
//
//        b2 = new JButton("You have " + meatItems + " meat items in the fridge.", meat);
//        add(b2);
//
//        b3 = new JButton(("add dairy"));
//        add(b3);
//
//        b4 = new JButton("You have " + dairyItems + " dairy items in the fridge.", dairy);
//        add(b4);
//
//        b5 = new JButton("show expired items");
//        add(b5);
//
//        item1 = new JTextField(10);
//        item1.setToolTipText("item name");
//        add(item1);
//
//        item2 = new JTextField(10);
//        item2.setToolTipText("expiry date YYYYMMDD");
//        add(item2);
//
//        b6 = new JButton("play background music");
//        add(b6);
//
//
//        TheHandler handler = new TheHandler();
//        b1.addActionListener(handler);
//        b3.addActionListener(handler);
//        b5.addActionListener(handler);
//        b6.addActionListener(handler);
//        item1.addActionListener(handler);
//        item2.addActionListener(handler);
    }

//    @Override
//    public void load() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("file.txt"));
//        for (String line : lines) {
//            ArrayList<String> partsOfLine = splitOnSpace(line);
//            if (partsOfLine.get(0).equals("Meat")) {
//                Meat meat = new Meat(partsOfLine.get(1));
//                meat.manualSetExpiry(partsOfLine.get(2));
//                foodEntries.add(meat);
//            } else if (partsOfLine.get(0).equals("Dairy")) {
//                Dairy dairy = new Dairy(partsOfLine.get(1));
//                dairy.manualSetExpiry(partsOfLine.get(2));
//                foodEntries.add(dairy);
//            }
//
//        }
//    }
//
//    @Override
//    public void save() throws IOException {
//
//        PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
//        clearTheFile();
//        for (FoodEntry f : foodEntries) {
//            String str = f.getClass().toString();
//            str = str.replaceAll("class FridgeObjects.", "");
//            writer.println(str + " " + f.getName() + " " + f.getExpiryDate());
//        }
//        writer.close();
// }


//    private class TheHandler implements ActionListener {
//
//        public void actionPerformed(ActionEvent event) {
//
//            if (event.getSource() == b1) {
//                if (!item1.getText().equals("")) {
//                    if (!item2.getText().equals("")) {
//                        Meat meat = new Meat(item1.getText());
//                        meat.manualSetExpiry(item2.getText());
//                        foodEntries.add(meat);
//                    } else {
//                        JFrame frame2 = new JFrame("warning!");
//                        frame2.setVisible(true);
//                        frame2.setSize(300, 600);
//                        JPanel panel = new JPanel();
//                        frame2.add(panel);
//                        JLabel label = new JLabel("that is not a valid date! yyyyMMdd");
//                        panel.add(label);
//                    }
//                } else {
//                    JFrame frame2 = new JFrame("warning!");
//                    frame2.setVisible(true);
//                    frame2.setSize(300, 600);
//                    JPanel panel = new JPanel();
//                    frame2.add(panel);
//                    JLabel label = new JLabel("that is not a valid name!");
//                    panel.add(label);
//                }
//            } else if (event.getSource() == b3) {
//                if (!item1.getText().equals("")) {
//                    if (!item2.getText().equals("")) {
//                        Dairy dairy = new Dairy(item1.getText());
//                        dairy.manualSetExpiry(item2.getText());
//                        foodEntries.add(dairy);
//                    } else {
//                        JFrame frame2 = new JFrame("warning!");
//                        frame2.setVisible(true);
//                        frame2.setSize(300, 600);
//                        JPanel panel = new JPanel();
//                        frame2.add(panel);
//                        JLabel label = new JLabel("that is not a valid date! yyyyMMdd");
//                        panel.add(label);
//                    }
//                } else {
//                    JFrame frame2 = new JFrame("warning!");
//                    frame2.setVisible(true);
//                    frame2.setSize(300, 600);
//                    JPanel panel = new JPanel();
//                    frame2.add(panel);
//                    JLabel label = new JLabel("that is not a valid name!");
//                    panel.add(label);
//                }
//            } else if (event.getSource() == b5) {
//                JFrame frame2 = new JFrame("checked expiry");
//                frame2.setVisible(true);
//                frame2.setSize(300, 600);
//                JPanel panel = new JPanel();
//                frame2.add(panel);
//                try {
//                    for (JLabel l : listExpiredFridgeItems()) {
//                        panel.add(l);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else if (event.getSource() == b6) {
//                playMusic = !playMusic;
//                if (playMusic) {
//                    mp.play();
//                } else
//                    mp.stop();
//            }
//        }
//    }

//    public static ArrayList<String> splitOnSpace(String line) {
//        String[] splits = line.split((" "));
//        return new ArrayList<>(Arrays.asList(splits));
//    }
//
//    public void clearTheFile() throws IOException {
//        FileWriter fwOb = new FileWriter("file.txt", false);
//        PrintWriter pwOb = new PrintWriter(fwOb, false);
//        pwOb.flush();
//        pwOb.close();
//        fwOb.close();
//    }

    /*public static void music(){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;

        try{
            BGM= new AudioStream((new FileInputStream("bgm.wav")));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }catch(IOException e){
            e.printStackTrace();
        }
        MGP.start(loop);

    }
    */

//    private void play(){
//        try {
//            JFXPanel j = new JFXPanel();
//            String uri = new File("bgm.mp3").toURI().toString();
//            new MediaPlayer(new Media(uri)).play();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

    public void addShelf(Shelf s){
        if (!shelves.contains(s)){
            shelves.add(s);
            addObserver(s);
        }
    }


    public int getMeats() {
        int meatItems = 0;
        for (FoodEntry e : foodEntries) {
            if (e instanceof Meat) {
                meatItems++;
            }
        }
        return meatItems;
    }

    public int getDairys() {
        int dairyItems = 0;
        for (FoodEntry e : foodEntries) {
            if (e instanceof Dairy) {
                dairyItems++;
            }
        }
        return dairyItems;
    }
    public List<FoodEntry> getFoodEntries(){
        return this.foodEntries;
    }

    //REQUIRES: valid food entry
    //MODIFIES: foodEntries
    //EFFECTS: adds food item to list
    public void addFoodEntry(FoodEntry f) {
        foodEntries.add(f);
    }


//    //UNUSED FUNCTION-> moved functionality to GUI
//    //MODIFIES: foodEntries
//    //EFFECTS: adds a meat or dairy item to your fridge, otherwise quit
//    public void addFridgeItems() throws IOException {
//
//        boolean adding = true;
//
//        while (adding) {
//            System.out.println("inputs allowed : meat, dairy, quit");
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("enter item type");
//            String itemType = scanner.nextLine();
//
//            if (itemType.equals("meat")) {
//                System.out.println("enter meat name");
//                String meatName = scanner.nextLine();
//                Meat meatItem = new Meat(meatName);
//                meatItem.addItem(meatItem);
//            }
//            if (itemType.equals("dairy")) {
//                System.out.println("enter dairy name");
//                String dairyName = scanner.nextLine();
//                Dairy dairyItem = new Dairy(dairyName);
//                dairyItem.addItem(dairyItem);
//            }
//            if (itemType.equals("quit")) {
//                adding = false;
//                scanner.nextLine();
//
//            } else if (!itemType.equals("quit") && !itemType.equals("meat") && !itemType.equals("dairy")) {
//                System.out.println("that is not an option!");
//            }
//        }
//    }

    //REQUIRES: each foodItem has an expiry date
    //EFFECTS: prints a warning message if foodItem is close to/past expiry date
    public ArrayList<JLabel> listExpiredFridgeItems() throws Exception {
        ArrayList<JLabel> labels = new ArrayList<>();
        List<String> expiredList = new ArrayList<>();
        JLabel holder;
        for (FoodEntry foodItem : foodEntries) {
            if (foodItem.expired()) {
                expiredList.add(foodItem.getName() + " is expired!");
            } else if (foodItem.getDPD() >= -2) {
                expiredList.add(foodItem.getName() + " is very close to expiry!");
            } else if (foodItem.getDPD() >= -7 ) {
                expiredList.add(foodItem.getName() + " should be used this week!");
            } else expiredList.add(foodItem.getName() + " is still good for " + (foodItem.getDPD() * -1) + "days");
        }
        for (int i=0; i < expiredList.size(); i++){
            holder = new JLabel();
            holder.setText(expiredList.get(i));
            labels.add(holder);
        }return labels;
    }
}