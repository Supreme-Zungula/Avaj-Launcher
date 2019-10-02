package za.co.wethinkcode.classes;
import za.co.wethinkcode.interfaces.Flyable;
import java.util.ArrayList;
import za.co.wethinkcode.classes.SimulationWriter;;
public class Tower
{
    private ArrayList<Flyable>    observers;

    Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        if (observers.contains(flyable) == false){
            observers.add(flyable);
            System.out.println("Registering a flyable");
            SimulationWriter.writeMessage("simulation.txt", "Tower says: Registered " + flyable.toString() + "\n");
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    protected void conditionsChanged() {
        for (Flyable flyable :  observers)
        {
            flyable.updateConditions();
        }   
    }
}