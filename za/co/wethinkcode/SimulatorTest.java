package za.co.wethinkcode;
import za.co.wethinkcode.factories.AircraftFactory;
import za.co.wethinkcode.interfaces.Flyable;
import java.io.*;
import java.util.ArrayList;


public class SimulatorTest
{
    public static boolean checkLine(String line) throws Exception
    {

        String[] aStrings = line.split(" ", 5);
        
        if (aStrings.length !=  5) {
            throw new Exception("Invalid input");
        }
    
        try {
            Integer.parseInt(aStrings[2]);
            Integer.parseInt(aStrings[3]);
            Integer.parseInt(aStrings[4]);
        }
        catch (Exception e){
            throw new Exception("Invalid scenerio.");
        }
        return (true); 
    }

    public static Flyable makeFlyable(String line) throws Exception
    {
        AircraftFactory factory = new AircraftFactory();
        String[] aStrings = line.split(" ", 5);
        String type = aStrings[0];
        String name = aStrings[1];
        int longitude = Integer.parseInt(aStrings[2]);
        int latitude = Integer.parseInt(aStrings[3]);
        int height = Integer.parseInt(aStrings[4]);
        
        return (factory.newAircraft(type, name, longitude, latitude, height));
    }

    public static void runSimulation(int numRuns, ArrayList<Flyable> alistFlyable)
    {
        for (Flyable  flyable : alistFlyable) {
            System.out.println(flyable);
        }
    }
    public static void main(String[] args) {
        int     simNumber;
        int     lineRead = 0;
        ArrayList<Flyable>  flyablesList ;

        try {
            File scenerioFile = new File(args[0]);
            FileReader fileReader = new FileReader(scenerioFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String      line;
            flyablesList = new ArrayList<>();

            line = bufferReader.readLine();
            simNumber = Integer.parseInt(line);
            System.out.println("number = " +  simNumber);

            while ((line = bufferReader.readLine()) != null) {
                lineRead++;

                if (line.isEmpty()) 
                    continue;
                if (checkLine(line)) {
                    flyablesList.add(makeFlyable(line));    
                }
                else {
                    throw new Exception("Invalid input");
                }    
            }
            bufferReader.close();
            runSimulation(simNumber, flyablesList);
        } catch (Exception exception) {
            System.out.println("Invalid scenerio at line " + lineRead);
            System.out.println(exception.toString());
        }
    }

}