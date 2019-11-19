package za.co.wethinkcode.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationWriter {

    public SimulationWriter() {
    }

    public static void writeToFile(String filePath, String message) {
        File file = new File(filePath);
        FileWriter fw;

        try {
            fw = new FileWriter(file, true);
            fw.write(message);
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException ex) {
            System.out.println("ERROR: could not write to the file\n");
            ex.printStackTrace();
        }
    }
}