package com.example.items;

import java.util.ArrayList;

public class MarkerCluster {

    public static final String CENTER = "center";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";
    public static final String JUSTIFY = "justify";

    private ArrayList<Marker> markers;
    private int height;
    private int width;
    private int borderRadius;
    private String backgroundColor;
    private String color;
    private String textAlign;
    private int fontSize;

    public MarkerCluster(){
        this.markers = new ArrayList<Marker>();
        this.height = 40;
        this.width = 40;
        this.borderRadius = 50;
        this.backgroundColor = "#3498db";
        this.color = "white";
        this.textAlign = this.CENTER;
        this.fontSize = 20;

    }

    public MarkerCluster(ArrayList<Marker> markers, int height, int width, int borderRadius, String backgroundColor, String color, String textAlign, int fontSize) {
        this.markers = markers;
        this.height = height;
        this.width = width;
        this.borderRadius = borderRadius;
        this.backgroundColor = backgroundColor;
        this.color = color;
        this.textAlign = textAlign;
        this.fontSize = fontSize;
    }

    public ArrayList<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(ArrayList<Marker> markers) {
        this.markers = markers;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void addMarker(Marker marker){
        this.markers.add(marker);
    }
}
