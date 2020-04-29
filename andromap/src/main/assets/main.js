// On initialise la latitude et la longitude de Paris (centre de la carte)
var macarte = null;
var markerClusters;
var markers = [];
var spotTab;
var userLocated = false;
var userLat = 48.856614;
var userLong = 2.3522219;
var tabIcon;
var activitySelected = false;
var creatingSpot = false;
var markerArray = Array();

window.onload = function(){
    // Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
    //getLocation();
    setMapSize();
    displayMap(6);
}

window.onresize = function () {
    setMapSize();
}

function setMapSize(){
    //On recupere la taille da la fenetre
    var width  = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
        height = window.innerHeight|| document.documentElement.clientHeight|| document.body.clientHeight;

//On adapte la taille de la carte a acelle de la fenetre
    document.getElementById('map').style.height = height.toString()+"px";
    document.getElementById('map').style.width = width.toString()+"px";
    document.getElementById('mainscreen').style.height = height.toString()+"px";
    document.getElementById('mainscreen').style.width = width.toString()+"px";
}

function displayMap(zoomLevel){
    // Créer l'objet "macarte" et l'insèrer dans  l'élément HTML qui a l'ID "map"
    document.getElementById("map").style.cursor = "default";
    macarte = L.map('map', {zoomControl: false}).setView([userLat, userLong], zoomLevel);
    markerClusters = new L.MarkerClusterGroup({
        iconCreateFunction: function (cluster) {
            return L.divIcon({
                html: cluster.getChildCount(),
                className: 'mycluster',
                iconSize: null
            });
        }
    });

    macarte.on('click', function(e){
        var coord = e.latlng;
        var lat = coord.lat;
        var lng = coord.lng;

    });

}

function layer(){
    // Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
    L.tileLayer('https://cartodb-basemaps-{s}.global.ssl.fastly.net/light_all/{z}/{x}/{y}.png', {
        minZoom: 1,
        maxZoom: 20
    }).addTo(macarte);
}


function generateMarker(width, height, imgLink, lat, long, id){
        macarte.addLayer(markerClusters);
        let x = 50;
        let y = 50*(height/width);
        var greenIcon = L.icon({
        iconUrl: imgLink,
        iconSize:     [x, y], // size of the icon
        iconAnchor:   [22, y], // point of the icon which will correspond to marker's location
        popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor

        });


        let marker = L.marker([lat, long], {icon: greenIcon}).on('click', function(e) {
            myMarkerClick(id);
        }).addTo(macarte);

        markerArray.push(marker);


         //markerClusters.addLayer(marker);
 }

    function loadFailure() {
         alert("'" + this.name + "' failed to load.");

    }

    function addMarker(imageLink, lat, long, id){
            var myImage = new Image();
            myImage.name = imageLink;
            myImage.onload = function() {
                generateMarker(this.width, this.height, imageLink, lat, long, id);
            };
            myImage.onerror = loadFailure;
            myImage.src = imageLink;
    }

    function showAndroidToast(toast) {
            AndroidInterface.showToast(toast);
    }

    function myMarkerClick(id){
        AndroidInterface.markerClick(id);
    }

    function getLecentre(){
        var cord = macarte.getCenter();
        showAndroidToast(cord.lat+"  |  "+cord.lng);
    }

    function getLeZoom(){
         showAndroidToast(macarte.getZoom());
    }

    function getCurrentMapData(){
        var cord = macarte.getCenter();
        var zoom = macarte.getZoom();
        AndroidInterface.setMapCoordinatesData(cord.lat, cord.lng, zoom);
    }

    function getLeBounds(){
        var bbox = macarte.getBounds();
        AndroidInterface.setMapBounds(bbox._southWest.lat, bbox._northEast.lat, bbox._northEast.lng, bbox._southWest.lng);
    }

    function clearPulse(){
        //markerClusters.clearLayers();
        for(let i=0; i<markerArray.lenght; i++){
            macarte.removeLayer(markerArray[i]);
        }
    }

</script>
