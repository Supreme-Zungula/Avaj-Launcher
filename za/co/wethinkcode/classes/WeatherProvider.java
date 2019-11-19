package za.co.wethinkcode.classes;
import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[]            weather = { "RAIN", "FOG", "SUN", "SNOW" };
    
    private WeatherProvider() {
        
    }
    
    public static WeatherProvider getProvider()
    {
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coords)
    {
        String  currentWeather;
        Random rand = new Random();
        int randNum = rand.nextInt(coords.getHeight() + 10);

        if (randNum >= 0 && randNum <= 20) {
            currentWeather = weather[0];
        }
        else if (randNum > 20 && randNum <= 40) {
            currentWeather = weather[1];
        }
        else if (randNum > 40 && randNum <= 60) {
            currentWeather = weather[2];
        }
        else {
            currentWeather = weather[3];
        }

        return (currentWeather);
    }
}