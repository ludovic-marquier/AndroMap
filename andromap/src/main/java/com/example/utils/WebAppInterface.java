package com.example.utils;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


import com.example.CustomView.Map;
import com.example.items.Marker;

import java.util.HashMap;

public class WebAppInterface {

    Context mContext;
    Map map;
    HashMap<String, Marker> markerList;

    /** Instantiate the interface and set the context */
    public WebAppInterface(Context c, Map map) {
        mContext = c;
        this.map = map;
    }



    @JavascriptInterface   // must be added for API 17 or higher
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void markerClick(String markerId){
        this.markerList = this.map.getMarkerList();
        Marker marker = markerList.get(markerId);
        marker.getClickMarker().onClick(marker);
    }


}