package za.co.wethinkcode.classes;
import za.co.wethinkcode.interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Helicopter(String name, Coordinates coords)
    {
        super(name, coords);
    }

    public void updateConditions() {
        int         height;
        int         longitude;
        String      currentWeather;
        
        currentWeather = this.weatherTower.getWeather(this.coordinates);
        height = this.coordinates.getHeight();
        longitude = this.coordinates.getLongitude();

        if (currentWeather.compareTo("SUN") == 0) {
            this.coordinates.setLongitude(longitude + 10);
            this.coordinates.setHeight( height + 2 );
        }
        else if (currentWeather.compareTo("RAIN") == 0) {
            this.coordinates.setLongitude( longitude + 5 );
        }
        else if (currentWeather.compareTo("FOG") == 0) {
            this.coordinates.setLongitude( longitude + 1 );
        }
        else if (currentWeather.compareTo("SNOW") == 0) {
            this.coordinates.setHeight( height + 12 );
        }

        if (this.coordinates.getHeight() > 100) {
            this.coordinates.setHeight((100));;
        }
        
        if (this.coordinates.getHeight() <= 0)
        {
            this.coordinates.setHeight(0);
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}