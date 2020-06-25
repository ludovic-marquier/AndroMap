package com.example.data;

public class MapBounds {

    private double nLat;
    private double sLat;
    private double eLong;
    private double wLong;

    public MapBounds(double nLat, double sLat, double eLong, double wLong) {
        this.nLat = nLat;
        this.sLat = sLat;
        this.eLong = eLong;
        this.wLong = wLong;
    }

    public double getnLat() {
        return nLat;
    }

    public void setnLat(double nLat) {
        this.nLat = nLat;
    }

    public double getsLat() {
        return sLat;
    }

    public void setsLat(double sLat) {
        this.sLat = sLat;
    }

    public double geteLong() {
        return eLong;
    }

    public void seteLong(double eLong) {
        this.eLong = eLong;
    }

    public double getwLong() {
        return wLong;
    }

    public void setwLong(double wLong) {
        this.wLong = wLong;
    }
}
