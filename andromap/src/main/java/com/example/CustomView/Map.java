package com.example.CustomView;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;


import com.example.data.Coordinates;
import com.example.data.MapBounds;
import com.example.data.MapState;
import com.example.eventHandler.OnMapLoadListener;
import com.example.items.Circle;
import com.example.items.Marker;
import com.example.items.MarkerCluster;
import com.example.utils.RandomGenerator;
import com.example.utils.WebAppInterface;

import java.util.HashMap;

public class Map extends WebView {

    private WebSettings webSettings;
    private String layer = TilesLayer.DEFAULT;
    private Boolean isMapLoaded = false;
    private String js;
    private Context context;
    private RandomGenerator randomGenerator;
    private HashMap<String , Marker> markerList = new HashMap<String, Marker>();
    private OnMapLoadListener listener;
    private double currentLatitutde;
    private double currentLongitude;
    private int currentZoomLevel;

    private double nLat;
    private double sLat;
    private double eLong;
    private double wLong;


    public Map(Context context) {
        super(context);
        this.context = context;
        show();
    }

    public Map(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        show();
    }

    public Map(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        show();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Map(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        show();
    }


    public void show(){
        super.loadUrl("file:///android_asset/map.html");
        randomGenerator = new RandomGenerator();
        webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.addJavascriptInterface(new WebAppInterface(this.getContext(), this), "AndroidInterface");
        this.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("WebView", consoleMessage.message());
                return true;
            }
        });
        this.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                addLayer(layer);
                isMapLoaded =true;
                listener.onMapLoaded();
            }
        });
    }

    public void message(String message){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.evaluateJavascript("javascript: alert('"+message+"');", null);
        } else {
            this.loadUrl("javascript: alert('"+message+"');");
        }
    }

    public void goTo(double latitude, double longitude, int zoomLevel){
       exeJavascript("macarte.flyTo(["+latitude+", "+longitude+"], "+zoomLevel+",{animate: true,duration: 2});");
    }

    public void goTo(Coordinates coordinates, int zoomLevel){
        exeJavascript("macarte.flyTo(["+coordinates.getLatitude()+", "+coordinates.getLongitude()+"], "+zoomLevel+",{animate: true,duration: 2});");
    }

    public void addMarker(final Marker marker){
        js ="";
        String markerId = randomGenerator.generateMarkerKey();
        Log.i("Webview", markerId);
        markerList.put(markerId, marker);
        if(marker.getIconLink() != null){
            js = "addMarker('file:///android_res/drawable/"+marker.getIconLink()+"',"+marker.getLatitude()+","+marker.getLongitude()+",'"+markerId+"');\n";
        }else{
            js = "var marker = L.marker(["+marker.getLatitude()+", "+marker.getLongitude()+"]).addTo(macarte);";
        }

        exeJavascript(js);

    }

    public void addCircle(Circle circle){
        String js = "var circle = L.circle(["+circle.getLatitude()+", "+circle.getLongitude()+"], {\n" +
                "    color: '"+circle.getColor()+"',\n" +
                "    fillColor: '"+circle.getFillColor()+"',\n" +
                "    fillOpacity: "+circle.getOpacity()+",\n" +
                "    radius: "+circle.getRadius()+"\n" +
                "}).addTo(macarte);";

        exeJavascript(js);
    }

    public void setLayer(String layer){
        this.layer = layer;
    }

    public void addLayer(String js){
        String layerJs = js+".addTo(macarte);";

        exeJavascript(layerJs);
    }

    public void addCluster(MarkerCluster cluster){
        String js = "var markersCluster = new L.MarkerClusterGroup();\n" +
                "\n" +
                "var cities = getCities();\n" +
                "for (var i = 0; i < cities.length; i++) {\n" +
                "    var latLng = new L.LatLng(cities[i][1], cities[i][2]);\n" +
                "    var marker = new L.Marker(latLng, {title: cities[i][0]});\n" +
                "    markersCluster.addLayer(marker);\n" +
                "}\n" +
                "\n" +
                "macarte.addLayer(markersCluster);";
    }

    public void getCenter(){
        exeJavascript("getLecentre()");
    }

    public void getZoom(){
        exeJavascript("getLeZoom()");
    }

    public HashMap<String, Marker> getMarkerList(){
        return this.markerList;
    }

    private void exeJavascript(String js){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.evaluateJavascript(js, null);
        } else {
            this.loadUrl(js);
        }
    }

    public void setOnMapLoadListener(OnMapLoadListener listener){
        this.listener = listener;
    }

    public double getCurrentLatitutde() {
        return currentLatitutde;
    }

    public void setCurrentLatitutde(double currentLatitutde) {
        this.currentLatitutde = currentLatitutde;
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

    public MapState getMapState(){
        return new MapState(this.currentLatitutde, this.currentLongitude, this.currentZoomLevel, new MapBounds(this.nLat, this.sLat, this.eLong, this.wLong));
    }

    public void clear(){
        exeJavascript("clearPulse()");
    }

    public void updateState(){
        exeJavascript("getCurrentMapData()");
        exeJavascript("getLeBounds()");



    }

    public MapBounds getMapBound(){
        return new MapBounds(this.nLat, this.sLat, this.eLong, this.wLong);
    }
}
