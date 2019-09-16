package za.co.wethinkcode.classes;
import za.co.wethinkcode.classes.Coordinates;

public class Aircraft {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;
    private long            idCounter;

    protected Aircraft(String name, Coordinates coords)
    {
        this.name = name;
        this.coordinates = coords;
        this.id = nextId();
    }
    public long getId(){
        return (id);
    }
    
    private long nextId() {
        return (++idCounter);    
    }
}