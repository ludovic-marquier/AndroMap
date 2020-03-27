package com.example.data;

public class MapState {

    private double currentLatitude;
    private double currentLongitude;
    private int currentZoomLevel;

    public MapState(){

    }

    public MapState(double currentLatitude, double currentLongitude, int currentZoomLevel) {
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
        this.currentZoomLevel = currentZoomLevel;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public int getCurrentZoomLevel() {
        return currentZoomLevel;
    }

    public void setCurrentZoomLevel(int currentZoomLevel) {
        this.currentZoomLevel = currentZoomLevel;
    }
}
