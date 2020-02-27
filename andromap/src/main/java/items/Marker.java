package items;

public class Marker {

    private double latitude;
    private double longitude;
    private String iconLink;

    public Marker(){

    }

    public Marker(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Marker(double latitude, double longitude, String iconLink) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.iconLink = iconLink;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }
}
