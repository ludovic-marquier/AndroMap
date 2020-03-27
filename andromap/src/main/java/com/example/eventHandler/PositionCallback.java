package com.example.eventHandler;

import com.example.items.Marker;

public interface PositionCallback {
    public void getMapLocation(double latitude, double longitude, int zoomLevel);
}
