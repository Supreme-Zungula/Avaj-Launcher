package za.co.wethinkcode.factories;
import java.lang.Exception;
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

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
    {
        Coordinates position = new Coordinates(longitude, latitude, height);
        Flyable airCraft;
        
        if (type.compareTo("Jetplane") == 0)
        {
          airCraft = new JetPlane(name, position);
        }
        else if (type.compareTo("Baloon") ==  0){
            airCraft = new Baloon(name, position);
        }
        else if (type.compareTo("Helicopter") == 0)
        {
            airCraft = new Helicopter(name, position);
        }
        else{
            throw new Exception("Invalid aircraft type");
        }
        return (airCraft);
    }
}