package za.co.wethinkcode.classes;
import java.util.Random;

public class WeatherTower extends Tower
{
    private String currentWeather;

    public String getWeather(Coordinates coords)
    {
        changeWeather();
        return (this.currentWeather);
    }

    private void changeWeather()
    {
        Random rand = new Random();
        String[] weather = {"RAIN",  "FOG", "SUN", "SNOW"};

        currentWeather = weather[rand.nextInt((5))];
        this.conditionsChanged();
    }
}