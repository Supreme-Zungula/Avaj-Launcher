package za.co.wethinkcode.classes;
import za.co.wethinkcode.interfaces.Flyable;
import java.io.FileWriter;;
public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public JetPlane(String name, Coordinates coords) 
    {
        super(name, coords);
    }
    
    @Override
    public void updateConditions()
    {
        int height;
        int latitude;
        String currentWeather;
        
        currentWeather = this.weatherTower.getWeather(this.coordinates);
        height = this.coordinates.getHeight();
        latitude = this.coordinates.getLatitude();

        if (currentWeather.compareTo("SUN") == 0)
        {
            this.coordinates.setLatitude(latitude + 10);
            this.coordinates.setHeight(height + 2);
        }
        else if (currentWeather.compareTo("RAIN") == 0) {
            this.coordinates.setLatitude(latitude + 5);
        }
        else if (currentWeather.compareTo("FOG") == 0) {
            this.coordinates.setLatitude(latitude + 1);
        }
        else if (currentWeather.compareTo("SNOW") == 0) {
            this.coordinates.setHeight(height + 7);
        }

        if (this.coordinates.getHeight() > 100) {
            this.coordinates.setHeight((100));;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            this.coordinates.setHeight(0);
            this.weatherTower.unregister(this);

            try {
                FileWriter fileWriter = new FileWriter("../simulation.txt");
                fileWriter.append("Tower says: unregistered Baloon {id: " + this.id + "}\n");
                fileWriter.close();
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        try {
            FileWriter fileWriter = new FileWriter("../simulation.txt");
            fileWriter.append("Tower says: Registered Baloon {id: " + this.id + "}\n");
            fileWriter.close();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}