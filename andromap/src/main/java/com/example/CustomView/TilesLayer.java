package com.example.CustomView;

public final class TilesLayer {

    private TilesLayer(){

    }

    public static final String DEFAULT =" L.tileLayer('https://cartodb-basemaps-{s}.global.ssl.fastly.net/light_all/{z}/{x}/{y}.png', {\n" +
            "        minZoom: 1,\n" +
            "        maxZoom: 20\n" +
            "    })";

    public static final String WATERCOLOR ="L.tileLayer('https://stamen-tiles-{s}.a.ssl.fastly.net/watercolor/{z}/{x}/{y}.{ext}', {\n" +
            "\tsubdomains: 'abcd',\n" +
            "\tminZoom: 1,\n" +
            "\tmaxZoom: 16,\n" +
            "\text: 'jpg'\n" +
            "})";

    public static final String TERRAIN  = "L.tileLayer('https://stamen-tiles-{s}.a.ssl.fastly.net/terrain/{z}/{x}/{y}{r}.{ext}', {\n" +
            "\tattribution: 'Map tiles by <a href=\"http://stamen.com\">Stamen Design</a>, <a href=\"http://creativecommons.org/licenses/by/3.0\">CC BY 3.0</a> &mdash; Map data &copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n" +
            "\tsubdomains: 'abcd',\n" +
            "\tminZoom: 0,\n" +
            "\tmaxZoom: 18,\n" +
            "\text: 'png'\n" +
            "})";

    public static final String TERRAIN_NO_LEGENDE = "L.tileLayer('https://stamen-tiles-{s}.a.ssl.fastly.net/terrain-background/{z}/{x}/{y}{r}.{ext}', {\n" +
            "\tattribution: 'Map tiles by <a href=\"http://stamen.com\">Stamen Design</a>, <a href=\"http://creativecommons.org/licenses/by/3.0\">CC BY 3.0</a> &mdash; Map data &copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n" +
            "\tsubdomains: 'abcd',\n" +
            "\tminZoom: 0,\n" +
            "\tmaxZoom: 18,\n" +
            "\text: 'png'\n" +
            "})";

    public static final String WORLD_IMAGERY = "L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {\n" +
            "\tattribution: 'Tiles &copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community'\n" +
            "})";

    public static final String WORLD_TERRAIN ="L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Terrain_Base/MapServer/tile/{z}/{y}/{x}', {\n" +
            "\tattribution: 'Tiles &copy; Esri &mdash; Source: USGS, Esri, TANA, DeLorme, and NPS',\n" +
            "\tmaxZoom: 13\n" +
            "})";

    public static final String WORLD_SHADE_RELIEF = "L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Shaded_Relief/MapServer/tile/{z}/{y}/{x}', {\n" +
            "\tattribution: 'Tiles &copy; Esri &mdash; Source: Esri',\n" +
            "\tmaxZoom: 13\n" +
            "})";

    public static final String VOYAGER = "L.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}{r}.png', {\n" +
            "\tattribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors &copy; <a href=\"https://carto.com/attributions\">CARTO</a>',\n" +
            "\tsubdomains: 'abcd',\n" +
            "\tmaxZoom: 19\n" +
            "})";

    public static final String VOYAGER_NO_LABEL = "L.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager_nolabels/{z}/{x}/{y}{r}.png', {\n" +
            "\tattribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors &copy; <a href=\"https://carto.com/attributions\">CARTO</a>',\n" +
            "\tsubdomains: 'abcd',\n" +
            "\tmaxZoom: 19\n" +
            "})";
}
