package za.co.wethinkcode.classes;

import java.util.HashMap;
import za.co.wethinkcode.interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Helicopter(String name, Coordinates coords)
    {
        super(name, coords);
        weatherTower = new WeatherTower();
    }


    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messagesHash = new HashMap<String, String>();

        messagesHash.put("SUN", "All sunny skies today.");
        messagesHash.put("RAIN", "Damn this rain is too much. I need to land");
        messagesHash.put("SNOW", "It's snowing, this not a weather for helicopters to fly.");
        messagesHash.put("FOG", "Eish it's so foggy I can't see anything.");

        if (currentWeather.equals("SUN")) {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        } else if (currentWeather.equals("RAIN")) {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        } else if (currentWeather.equals("FOG")) {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        } else if (currentWeather.equals("SNOW")) {
            this.coordinates.setHeight(this.coordinates.getHeight() + 12);
        } else {
            return;
            // throw new Exception("ERROR: Invalid weather type.");
        }

        String message = "Helicopter#" + this.name + " (" + this.id + "): " + messagesHash.get(currentWeather);
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        String message = "Tower says: " + "Helicopter#" + this.name + " (" + this.id + "): " + "Registered to the tower.";
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }
}