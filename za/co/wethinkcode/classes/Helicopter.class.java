package za.co.wethinkcode.classes;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Helicopter(String name, Coordinates coords)
    {
        this.name = name;
        this.coordinates = coords;
    }

    public void updateConditions() {
        
    }

    public void registerTower(WeatherTower weatherTower) {
        
    }
}