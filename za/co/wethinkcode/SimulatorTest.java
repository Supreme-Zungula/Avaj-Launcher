import java.io.*;
import za.co.wethinkcode.*;
import za.co.wethinkcode.classes.Coordinates;
import za.co.wethinkcode.factories.AircraftFactory;
import za.co.wethinkcode.interfaces.Flyable;

public class SimulatorTest
{
    public static void checkLine(String line) {
        String[] aStrings = line.split(" ", 5);
        String type = aStrings[0];
        String name = aStrings[1];
        int longitude = Integer.parseInt(aStrings[2]);
        int latitude = Integer.parseInt(aStrings[3]);
        int height = Integer.parseInt(aStrings[4]);

        AircraftFactory aircraftFactory = new AircraftFactory();
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        
        Flyable flyable = aircraftFactory.newAircraft(type, longitude, latitude, height);
        System.out.println(flyable.toString());
    }
    
    public static void main(String[] args) {
        int   simNumber;
        try {
            File scenerioFile = new File(args[0]);
            FileReader fileReader = new FileReader(scenerioFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String      line;
            String[]    arrOfStrings;
            
            line = bufferReader.readLine();
            simNumber = Integer.parseInt(line);
            System.out.println("number = " +  simNumber);
            while ((line = bufferReader.readLine()) != null) {
                checkLine(line);
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

}