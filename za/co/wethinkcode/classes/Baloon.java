package za.co.wethinkcode.classes;

import za.co.wethinkcode.interfaces.Flyable;
import java.util.HashMap;
// import java.lang.Exception;
import za.co.wethinkcode.classes.SimulationWriter;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coords) {
        super((name), coords);
        weatherTower = new WeatherTower();
    }

    @Override
    public void updateConditions() {
        System.out.println("Baloon updateConditions");
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messagesHash = new HashMap<String, String>();

        messagesHash.put("SUN", "Ah such a great weather to fly.");
        messagesHash.put("RAIN", "Damn this rain is too.");
        messagesHash.put("SNOW", "It's snowing and I am deflating. I hate winter.");
        messagesHash.put("FOG", "Eish it's so foggy I can't see anything.");

        if (currentWeather.equals("SUN")) {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 2);
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
        } else if (currentWeather.equals("RAIN")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
        } else if (currentWeather.equals("FOG")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
        } else if (currentWeather.equals("SNOW")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        } else {
            return;
            // throw new Exception("ERROR: Invalid weather type.");
        }

        String message = "Baloon#" + this.name + " (" + this.id + "): " + messagesHash.get(currentWeather);
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        String message = "Tower says: " + "Baloon#" + this.name + " (" + this.id + "): " + "Registered to the tower.";
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }
}