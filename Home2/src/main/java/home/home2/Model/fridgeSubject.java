package home.home2.Model;

import home.home2.Model.Beans.fridgeBean;

import java.util.ArrayList;
import java.util.List;

public class fridgeSubject {

    List<fridgeObserver> observers = new ArrayList<fridgeObserver>();


    public void attach(fridgeObserver observer ){
        observers.add(observer);
    }

    public void dettach(fridgeObserver observer){
        observers.remove(observer);
    }

    public void notifyObserversNewIngredient(fridgeBean fridgebean){
        for(fridgeObserver observer : observers){
            observer.update(fridgebean);
        }

    }
}
