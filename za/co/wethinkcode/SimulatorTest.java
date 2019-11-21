package za.co.wethinkcode;

import java.util.ArrayList;
import java.io.*;
import za.co.wethinkcode.factories.AircraftFactory;
import za.co.wethinkcode.interfaces.Flyable;
import za.co.wethinkcode.classes.SimulationWriter;
import za.co.wethinkcode.classes.WeatherTower;;
// import za.co.wethinkcode.classes.WeatherProvider;

public class SimulatorTest {
    public static boolean checkLine(String line) throws Exception {

        String[] aStrings = line.split(" ", 5);
        System.out.println("line = " + line + '\n');
        if (aStrings.length != 5) {
            throw new Exception("Invalid aircraft details.");
        }

        try {
            Integer.parseInt(aStrings[2]);
            Integer.parseInt(aStrings[3]);
            Integer.parseInt(aStrings[4]);
        } catch (Exception e) {
            throw new Exception("Invalid scenerio.");
        }
        return (true);
    }

    public static Flyable makeFlyable(String line) throws Exception {
        AircraftFactory factory = new AircraftFactory();
        String[] aStrings = line.split(" ", 5);
        String type = aStrings[0];
        String name = aStrings[1];
        int longitude = Integer.parseInt(aStrings[2]);
        int latitude = Integer.parseInt(aStrings[3]);
        int height = Integer.parseInt(aStrings[4]);

        return (factory.newAircraft(type, name, longitude, latitude, height));
    }

    public static void main(String[] args) {
        int simNumber;
        int lineRead = 1;
        ArrayList<Flyable> flyablesList;
        WeatherTower weatherTower = new WeatherTower();
        try {
            File scenerioFile = new File(args[0]);
            FileReader fileReader = new FileReader(scenerioFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            flyablesList = new ArrayList<>();

            line = bufferReader.readLine();
            simNumber = Integer.parseInt(line);
            System.out.println("number = " + simNumber);
            // SimulationWriter.writeToFile("Test.txt", line);

            while ((line = bufferReader.readLine()) != null) {
                lineRead++;
                // SimulationWriter.writeToFile("Test.txt", line);
                if (line.isEmpty())
                    continue;
                if (checkLine(line)) {
                    Flyable newFlyable = makeFlyable(line);
                    weatherTower.register(newFlyable);
                    newFlyable.registerTower(weatherTower);
                    flyablesList.add(newFlyable);
                } else {
                    throw new Exception("Invalid input");
                }
            }
            bufferReader.close();
            while (simNumber > 0) {
                weatherTower.changeWeather();
                --simNumber;
            }
        } catch (Exception exception) {
            System.out.println("Invalid scenerio at line " + lineRead);
            System.out.println(exception.getMessage());
        }

    }

}