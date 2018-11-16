package Observer;

import Fridge.MyFridge;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<FridgeObserver> fridgeObservers = new ArrayList<>();

    public void addObserver(FridgeObserver fridgeObserver){
        if(!fridgeObservers.contains(fridgeObserver)){
            fridgeObservers.add(fridgeObserver);

        }
    }
    public void notifyObservers(MyFridge myfridge){
        for (FridgeObserver observer: fridgeObservers){
            observer.update(myfridge);
        }

    }
    public void removeObservers(MyFridge myfridge){
        for (FridgeObserver observer: fridgeObservers){
            observer.update((myfridge));
        }
    }

}
