package za.co.wethinkcode.classes;
import java.io.*;

public class Aircraft{
    protected long          id;
    protected String        name;
    protected Codrdinates   coordinates;
    private long            idCounter;
    protected Aircraft(String name, Coordinates coords)
    {
        this.name = name;
        this.coordinates = coords;
    }

    long nextIf() {
        return (this.idCounter);    
    }
}