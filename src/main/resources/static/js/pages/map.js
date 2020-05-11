const coordsPrecision = 6;

let map;
let ignite = (location) => {
    let browserLat = location.coords.latitude;
    let browserLong = location.coords.longitude;
    console.log(browserLat);
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: browserLat, lng: browserLong},
        zoom: 8
    });
}
let geolocation = navigator.geolocation.getCurrentPosition(ignite);