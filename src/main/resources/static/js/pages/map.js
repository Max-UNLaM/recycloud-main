const initialZoom = 15;
const mapId = "map";

const iconTemplate = (categories) => {
    return `
    <div class="no-background pin-tooltip">${badgeTemplate(categories, 'primary margin-1')}</div>
    <div class="pin-container flex">
        <img class="pin-image" alt="pin" src="img/map/map_ping_green.svg">    
    </div>   
    `;
}

const badgeTemplate = (days, badgeType) => {
    return days.map(function (day) {
        return '<span class="badge badge-' + badgeType + '">' + day + '</span>'
    }).join(" ");
}

const baseTemplate = (dialog) => {
    return `
<div id="content">
    <div id="siteNotice">${badgeTemplate(dialog.categories, 'primary')}</div>
    <h1 id="firstHeading" class="firstHeading">${dialog.firstHeading}</h1>
    <div id="bodyContent">
        <p>${dialog.bodyContent}</p>
        <p><a href="${dialog.link}">Site</a></p>
        <p>${badgeTemplate(dialog.days, 'secondary')}</p>
        <p>${dialog.schedule}</p>
    </div>
</div>
`;
};

class Icon {
    name = "";
    location = "";
    size = {width: 10, height: 10};
}

class Coords {
    latitude;
    longitude;
}

class Dialog {
    firstHeading = "";
    bodyContent = "";
    days = [];
    schedule = "";
    link = "";
}

class Feature {
    title = "";
    coords = new Coords();
    icon = new Icon();
    dialog = new Dialog();
}

let features = [{
    title: "Tu Vieja",
    coords: {
        lat: -34.695922,
        lng: -58.604702
    },
    icon: {
        url: "img/map/map_ping_green.svg",
        scaledSize: {
            width: 47,
            height: 64
        }
    },
    dialog: {
        categories: ["CARTÓN", "FALOPA"],
        firstHeading: "Tu Vieja",
        bodyContent: "La farmacia que le gust a tu vieja",
        days: ["lunes", "martes", "tu vieja"],
        schedule: "De 0 a 2am",
        link: "tuvieja.com"
    }
}]

let ignite = (location) => {
    let browserLat = location.coords.latitude;
    let browserLong = location.coords.longitude;
    let map = new google.maps.Map(document.getElementById(mapId), {
        center: {lat: browserLat, lng: browserLong},
        zoom: initialZoom
    });
    features.forEach((feature) => {
        let infoWindow = new google.maps.InfoWindow({
            content: baseTemplate(feature.dialog)
        });

        let marker = new RichMarker({
            position: new google.maps.LatLng(feature.coords.lat, feature.coords.lng),
            map: map,
            content: iconTemplate(feature.dialog.categories),
            title: feature.title,
            shadow: 0
        });
        marker.addListener('click', function () {
            infoWindow.open(map, marker);
        });
    });
}

function initMap() {
    navigator.geolocation.getCurrentPosition(ignite);
}
