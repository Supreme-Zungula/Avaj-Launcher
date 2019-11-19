package za.co.wethinkcode.classes;
<<<<<<< HEAD

=======
import za.co.wethinkcode.classes.SimulationWriter;
>>>>>>> 4ac031ada69fa9f55d2c5a48b372cb97ff8a264a
import za.co.wethinkcode.interfaces.Flyable;
import za.co.wethinkcode.classes.SimulationWriter;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Baloon(String name, Coordinates coords)
    {
        super((name), coords);
    }

    @Override
    public void updateConditions() 
    {
        int         height;
        int         longitude;
        String      currentWeather;

        height = this.coordinates.getHeight();
        longitude = this.coordinates.getLongitude();
        currentWeather= this.weatherTower.getWeather(this.coordinates);
        
        if (currentWeather.compareTo("SUN") == 0 ){
            this.coordinates.setLongitude(longitude + 2);
            this.coordinates.setHeight(height + 4);
        }
        else if (currentWeather.compareTo("RAIN") == 0) {
            this.coordinates.setLongitude( longitude + 5);
        }
        else if (currentWeather.compareTo("FOG") == 0) {
            this.coordinates.setLongitude( longitude + 1 );
        }
        else if (currentWeather.compareTo("SNOW") == 0) {
            this.coordinates.setHeight( height + 15 );
        }

        if (this.coordinates.getHeight() > 100) {
            this.coordinates.setHeight((100));;
        }
        
        if (this.coordinates.getHeight() <= 0)
        {
            this.coordinates.setHeight(0);
            this.weatherTower.unregister(this);
<<<<<<< HEAD
            
            String message = "Tower says: unregistered Baloon {id: " + this.id + "}\n";
            SimulationWriter.writeToFile("../simulation.txt", message);
=======
            SimulationWriter.writeMessage("../simulation.txt", "Baloon says: Landed safely\n");
>>>>>>> 4ac031ada69fa9f55d2c5a48b372cb97ff8a264a
        }
    }   

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
<<<<<<< HEAD
=======
        SimulationWriter.writeMessage("../simulation.txt", "Tower says: Registered Baloon {id: " + this.id + "}\n");
>>>>>>> 4ac031ada69fa9f55d2c5a48b372cb97ff8a264a
    }
}