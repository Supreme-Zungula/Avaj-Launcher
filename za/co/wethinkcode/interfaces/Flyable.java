package za.co.wethinkcode.interfaces;
import za.co.wethinkcode.classes.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}