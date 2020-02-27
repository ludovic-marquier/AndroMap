package CustomView;

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

import items.Circle;
import items.Marker;


public class Map extends WebView {

    private WebSettings webSettings;
    private String layer = TilesLayer.DEFAULT;

    public Map(Context context) {
        super(context);
    }

    public Map(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Map(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Map(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void show(){
        webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("WebView", consoleMessage.message());
                return true;
            }
        });
        super.loadUrl("file:///android_asset/map.html");
        this.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                addLayer(layer);
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

    public void goTo(){
       exeJavascript("macarte.flyTo([13.87992, 45.9791], 12);");
    }

    public void addMarker(Marker marker){
        String js ="";
        if(marker.getIconLink() != null){
            js = "addMarker('file:///android_res/drawable/"+marker.getIconLink()+"',"+marker.getLatitude()+","+marker.getLongitude()+");\n";
        }else{
            js = "var marker = L.marker(["+marker.getLatitude()+", "+marker.getLongitude()+"]).addTo(macarte);";
        }

        Log.i("LOCATION JS", js);
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

    private void exeJavascript(String js){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.evaluateJavascript(js, null);
        } else {
            this.loadUrl(js);
        }
    }


}
