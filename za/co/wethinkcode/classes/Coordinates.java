package za.co.wethinkcode.classes;

public class Coordinates
{
    private int     longitude;
    private int     latitude;
    private int     height;
    
    public Coordinates(int longt, int lati, int h)
    {
        this.longitude = longt;
        this.latitude = lati;
        this.height = h;
    }

    public int getLongitude() {
        return (this.longitude);
    }

    public int getLatitue() {
        return (this.latitude);
    }

    public int  getHeight() {
        return (this.height);
    }
}