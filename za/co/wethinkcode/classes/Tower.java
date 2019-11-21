package za.co.wethinkcode.classes;

import za.co.wethinkcode.interfaces.Flyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;

    Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        if (observers.contains(flyable) == false) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}