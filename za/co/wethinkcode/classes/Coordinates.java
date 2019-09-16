package za.co.wethinkcode.classes;

public class Coordinates {
    private int     longitude;
    private int     latitude;
    private int     height;
    
    public Coordinates(int longt, int lati, int height) {
        if (longt >= 0 && lati >= 0 && height >= 0) {
            this.longitude = longt;
            this.latitude = lati;
            this.height = height;
        }
    }

    public void setLongitude(int value) {
        if (value >= 0)
            this.longitude = value;
    }

    public int getLongitude() {
        return (this.longitude);
    }

    public void setLatitude(int value) {
        if (value >= 0) {
            this.latitude = value;
        }
    }

    public int getLatitude() {
        return (this.latitude);
    }

    public void setHeight(int value) {
        if (height >= 0 && height <= 100) {
            this.height = value;
        } else if (height < 0) {
            this.height = 0;
        } else {
            this.height = 100;
        }
    }

    public int getHeight() {
        return (this.height);
    }
}