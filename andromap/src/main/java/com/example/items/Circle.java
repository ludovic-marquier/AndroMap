package com.example.items;

public class Circle {

    private double latitude;
    private double longitude;
    private String color;
    private String fillColor;
    private float opacity;
    private int radius;

    public Circle(){

    }

    public Circle(double latitude, double longitude, String color, String fillColor, float opacity, int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.color = color;
        this.fillColor = fillColor;
        this.opacity = opacity;
        this.radius = radius;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
