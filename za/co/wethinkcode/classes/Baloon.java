package za.co.wethinkcode.classes;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Baloon(String name, Coordinates coords)
    {
        this.name = name;
        this.coordinates = coords;
    }

    protected void updateConditions() {
        
    }

    public void registerTower(WeatherTower weatherTower) {
        
    }
}