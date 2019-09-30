package za.co.wethinkcode.classes;
import za.co.wethinkcode.classes.WeatherProvider;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coords)
    {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        return (weatherProvider.getCurrentWeather(coords));
    }

    private void changeWeather()
    {
        conditionsChanged();
    }
}