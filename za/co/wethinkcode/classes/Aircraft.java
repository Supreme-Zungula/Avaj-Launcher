package za.co.wethinkcode.classes;

import za.co.wethinkcode.classes.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coords) {
        this.name = name;
        this.coordinates = coords;
        this.id = nextId();
    }

    private long nextId() {
        return (++idCounter);
    }

    public long getId() {
        return (id);
    }

    public String getName() {
        return (this.name);
    }

    @Override
    public String toString() {
        
        String details = "ID: " + getId() + 
                        " Name: " + getName() +  
                        " Coordinates: " + this.coordinates.getLatitude() +
                        " " + this.coordinates.getLongitude() + 
                        " " + this.coordinates.getHeight();
        return (details);
    }
}