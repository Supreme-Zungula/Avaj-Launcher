package za.co.wethinkcode.classes;
import java.io.FileWriter;

public class SimulationWriter 
{
	public static void writeMessage(String filePath, String message)
	{
		try {    
			FileWriter fileWriter = new FileWriter(filePath);
			// fileWriter.write(message);
			fileWriter.append(message);   
			fileWriter.close();    
		} catch(Exception ex) { 
			   System.out.println(ex.getMessage());
		}     
	}
}