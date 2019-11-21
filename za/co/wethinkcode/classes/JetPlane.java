package za.co.wethinkcode.classes;

import za.co.wethinkcode.interfaces.Flyable;
import za.co.wethinkcode.classes.SimulationWriter;
import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coords) {
        super(name, coords);
        this.weatherTower = new WeatherTower();
    }

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messagesHash = new HashMap<String, String>();

        messagesHash.put("SUN", "Ah sunny skies, I guess I can go supersonic.");
        messagesHash.put("RAIN", "It's raining I must slow down.");
        messagesHash.put("SNOW", "It's snowing, I can't fly in such a weather.");
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

        String message = "JetPlane#" + this.name + " (" + this.id + "): " + messagesHash.get(currentWeather);
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        String message = "Tower says: " + "JetPlane#" + this.name + " (" + this.id + "): " + "Registered to the tower.";
        SimulationWriter.writeToFile("SimulationLog.txt", message);
    }
}