package za.co.wethinkcode.classes;

public class WeatherProvider
{
    private WeatherProvider     weatherProvider;
    private String[]            weather;
    
    private WeatherProvider(){
        weatherProvider = new WeatherProvider();

        this.weather[0] = "RAIN";
        this.weather[1] = "FOG";
        this.weather[1] = "SUN";
        this.weather[1] = "SNOW";
    }
    
    public WeatherProvider getProvider()
    {
        return (this.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coords)
    {
        WeatherTower weatherStation = new WeatherTower();
        return (weatherStation.getWeather(coords));
    }
}