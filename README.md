# Andromap

Andromap is an [OpenStreetMap](https://www.openstreetmap.org) and [Leaflet](https://leafletjs.com/) based Java library intended to display maps easily on and Android application.

## How it works
The Map is in fact an object that extends WebView and in wich is loaded the OpenStreetMap API with Javascript in a local HTML file.
The Library is a group of class and methods that make the bridge beetween the Java Application code and the Javascript Map code. So it allows you to use the map as a classic Android View.

## Setup

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency:
```gradle
implementation 'com.github.ludovic-marquier:AndroMap:0.4'
```

LATEST-VERSION is [![](https://jitpack.io/v/tiagohm/MarkdownView.svg)](https://jitpack.io/#tiagohm/MarkdownView)

## Usage

```xml
<CustomView.Map
android:id="@+id/map"
android:layout_width="match_parent"
android:layout_height="match_parent"/>
```
```java
myMap = findViewById(R.id.map);
```

## Apply tiles
```java
myMap.setLayer(TilesLayer.WORLD_IMAGERY);
```

## Adding a Marker
```java
//add a simple Marker with Latitude and Longitude
map.addMarker(new Marker(45.09,2.47));
```
If you want to add a Marker at the creation of the View, we recommend you to wait for the map finishes to load before adding it. You can do it this way :

```java
map.setOnMapLoadListener(new OnMapLoadListener() {
            @Override
            public void onMapLoaded() {
                map.addMarker(new Marker(45.09,2.47));
            }
        });
```

## Custom icon Marker
First, put your .png file into the res/drawable folder, then you simply have to add the image name into the constructor of the Marker like this :

```java
//Marker with custom icon
Marker marker = new Marker(45.09,2.47, "my_icon.png");
```

Or, you can use the setter

```java
//Marker with custom icon
Marker marker = new Marker(45.09,2.47);
marker.setIconLink("my_icon.png");
```

## Marker onClick Event
The map is running into the webView environement, so you can't simply implement the View.OnClickListener Interface to handle the click. The OnClickMarker is here for you.

```java
//Marker click handle
 marker.setOnClickMarker(new OnClickMarker() {
                    @Override
                    public void onClick(Marker marker) {
                        //YOUR CODE HERE
                    }
                });
```

## Link a data object to a Marker
You will probably need to link an Object to a Marker for representing something you want to show on the map.

```java
MyDataObject object = new DataObject();
marker.setObjectData(object);
```

## LICENSE
```
Copyright 2020-2021 ludomav

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
