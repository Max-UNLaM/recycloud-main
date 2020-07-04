const initialZoom = 15;
const mapId = 'punto-map';
const ubicate = $('#ubicate');
let map;

ubicate.popover({
    trigger: 'hover',
    title: '¿No encuentras tu ubicación?',
    content: 'Especificá la localidad y no el partido y elegí provincia. Ejemplo: Usar Ciudadela y no Tres de Febrero'
})

function moveMap(lat, lng) {
    let position = new google.maps.LatLng(lat, lng)
    map.setCenter(position)
    new google.maps.Marker({
        position: position,
        map: map,
        title: 'Ubicación'
    });
}

function validateLocation() {
    const address = $('#address').val();
    const city = $('#city').val();
    const province = $('#province').val();
    const coordinates = $('#coordinates');
    return request({url: `/api/geolocate?address=${address}, ${city}, ${province}, Argentina`})
        .then(data => {
            data = JSON.parse(data);
            moveMap(data.lat, data.lng)
            coordinates.val(`${data.lat}, ${data.lng}`);
        });
}

const ignite = (location) => {
    const browserLat = location.coords.latitude;
    const browserLong = location.coords.longitude;
    map = new google.maps.Map(document.getElementById(mapId), {
        mapTypeControl: false,
        center: {
            lat: browserLat,
            lng: browserLong
        },
        zoom: initialZoom
    });
    afterInit()
}

function initMap() {
    navigator.geolocation.getCurrentPosition(ignite);
}