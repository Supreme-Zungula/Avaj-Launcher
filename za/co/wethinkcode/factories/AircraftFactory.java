package za.co.wethinkcode.factories;
import javax.activity.InvalidActivityException;

import za.co.wethinkcode.classes.Aircraft;
import za.co.wethinkcode.classes.Baloon;
import za.co.wethinkcode.classes.Coordinates;
import za.co.wethinkcode.classes.JetPlane;
import za.co.wethinkcode.classes.Helicopter;
import za.co.wethinkcode.interfaces.Flyable;

public class AircraftFactory 
{

    public AircraftFactory() 
    {
    }

    public Flyable newAircraft(String type, int longitude, int latitude, int height) {
        Coordinates position = new Coordinates(longitude, latitude, height);
        
        if (type.compareTo("Jetplane") == 0)
        {
            return ( new JetPlane("Star Scream", position));
        }
        else if (type.compareTo("Baloon") ==  0){
            return (new Baloon("Hot air baloon", position));
        }
        else if (type.compareTo("Helicopter") == 0)
        {
            return (new Helicopter("Cyborgomus Prime", position));
        }
        else{
            System.out.println("Invalid aircraft type");
        }
        return (new JetPlane(type, position));
    }
}