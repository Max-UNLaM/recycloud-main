const initialZoom = 16;
const mapId = 'map';
const paddleIcons = 'http://maps.google.com/mapfiles/kml/paddle';

const icons = [{
    bronze: {
        icon: paddleIcons + 'red_blank.png'
    },
    plastic: {
        icon: paddleIcons + 'purple_blank.png'
    },
    top: {
        icon: paddleIcons + 'purple_star.png'
    },
    metal: {
        icon: paddleIcons + 'blue_blank.png'
    },
    bottles: {
        icon: paddleIcons + 'tlblu_diamond.png'
    },
    bateries: {
        icon: paddleIcons + 'yellow_blank.png'
    },
    paperboard: {
        icon: paddleIcons + 'white_diamond.png'
    },
    electronic: {
        icon: paddleIcons + 'yellow_diamond.png'
    },
    glass: {
        icon: paddleIcons + 'tlblu_blank.png'
    },
    textiles: {
        icon: paddleIcons + 'orange_blank.png'
    },
    other: {
        icon: paddleIcons + 'blue_blank.png'
    }
}]

let features = [

    -34.6937483!4d-58.6060706
]

let map;
let ignite = (location) => {
    let browserLat = location.coords.latitude;
    let browserLong = location.coords.longitude;
    console.log(browserLat);
    map = new google.maps.Map(document.getElementById(mapId), {
        center: {lat: browserLat, lng: browserLong},
        zoom: initialZoom
    });
}
let geolocation = navigator.geolocation.getCurrentPosition(ignite);