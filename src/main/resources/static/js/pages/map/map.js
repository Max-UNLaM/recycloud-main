const initialZoom = 15;
const mapId = "map";
const pinBaseUrl = "/api/pin";
const categoryKey = "categories";
const pinFilterUrl = `${pinBaseUrl}${window.location.search}`;
const params = new URLSearchParams(window.location.search);
const category = params.get(categoryKey);
let mapHandler = {
    updateMap: (url) => {
    },
    beforeUpdate: () => {
    }
}
let markers = [];

class Location {
    type = "";
    coordinates = [];
}

class Dialog {
    first_heading = "";
    body_content = "";
    days = [];
    schedule = "";
    link = "";
    address = "";
    categories = "";
}

class Pin {
    title = "";
    categories = [];
    location = new Location();
    icon = new Icon();
    dialog = new Dialog();
}

/**
 *
 * @param {string[]} categories
 * @returns {string}
 */
const iconTemplate = (categories) => {
    return `
    <div class="no-background pin-tooltip">${badgeTemplate(categories, 'primary margin-1')}</div>
    <div class="pin-container flex">
        <img class="pin-image pin-image-size" alt="pin" src="../../../img/map/map_ping_green.svg">    
    </div>   
    `;
}

const badgeTemplate = (items, badgeType) => {
    return items.map(function (item) {
        return '<span class="badge badge-' + badgeType + '">' + item + '</span>'
    }).join(" ");
}

/**
 *
 * @param {Dialog} dialog
 * @returns {string}
 */
const dialogTemplate = (dialog) => {
    return `
<div id="content">
    <div id="siteNotice" class="text-center">${badgeTemplate(dialog.categories, 'primary')}</div>
    <h2 id="firstHeading" class="firstHeading text-center my-3 font-weight-bold color-verde">${dialog.first_heading}</h2>
    <div id="bodyContent">
        <p>${dialog.body_content}</p>
        <p>${dialog.address}</p>
        <p><a target="_blank" href="${dialog.link}">Ir al sitio </a></p>
        <p>${badgeTemplate(dialog.days, 'secondary')}</p>
        <p>${dialog.schedule}</p>
    </div>
</div>
`;
};

/**
 *
 * @param {float[]} coords
 * @returns {Promise<google.maps.InfoWindow>}
 */
const buildInfoWindow = (coords) => {
    const queryCoords = `${coords[0]},${coords[1]}`;
    return request({url: `/api/pin/${queryCoords}/dialog`})
        .then(data => {
            return new google.maps.InfoWindow({
                content: dialogTemplate(JSON.parse(data))
            });
        });
}

/**
 *
 * @param {Pin[]} pines
 * @param map
 */
function addPinesToMap(pines, map) {
    pines.forEach((pin) => {
        let marker = new RichMarker({
            position: new google.maps.LatLng(pin.location.coordinates[0], pin.location.coordinates[1]),
            map: map,
            content: iconTemplate(pin.categories),
            title: pin.title,
            shadow: 0
        });
        marker.addListener('click', async function () {
            const infoWindow = await buildInfoWindow(pin.location.coordinates);
            if(!marker.open){
                infoWindow.open(map,marker);
                marker.open = true;
            }
            else{
                infoWindow.close();
                marker.open = false;
            }
            google.maps.event.addListener(map, 'click', function() {
                infoWindow.close();
                marker.open = false;
            });
        });
        markers.push(marker);
    });
}

function cleanMarkers(map) {
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

const deleteMarkers = () => {
    cleanMarkers(null);
    markers = [];
}

let ignite = (location) => {
    const browserLat = location.coords.latitude;
    const browserLong = location.coords.longitude;

    let map = new google.maps.Map(document.getElementById(mapId), {
        mapTypeControl: false,
        clickableIcons: false,
        center: {
            lat: browserLat,
            lng: browserLong
        },
        zoom: initialZoom
    });
    mapHandler.updateMap = (path) => {
        mapHandler.beforeUpdate();
        request({url: path})
            .then(data => {
                addPinesToMap(JSON.parse(data), map);
            });
    };
    if (window.location.search != '') {
        mapHandler.updateMap(pinFilterUrl);
    }
    mapHandler.beforeUpdate = deleteMarkers;
    map.addListener('zoom_changed', () => {
        const pinImageClass = $('.pin-image-size');
        const pinContainer = $('.pin-container');
        const pinTooltip = $('.pin-tooltip');
        if (map.zoom <= 22) {
            changeClassSize(pinImageClass, '28px', '40px');
        }
        if (map.zoom < 15) {
            changeClassSize(pinImageClass, '28px', '40px');
        }
        if (map.zoom < 13) {
            changeClassSize(pinImageClass, '25px', '36px');
        }
        if (map.zoom > 11) {
            if (pinContainer.css('display') === 'none') {
                pinContainer.fadeIn('fast');
                pinTooltip.fadeIn('fast');
            }
        }
        if (map.zoom < 11) {
            changeClassSize(pinImageClass, '20px', '28px');
            if (pinContainer.css('display') !== 'none') {
                pinContainer.fadeOut('fast');
                pinTooltip.fadeOut('fast')
            }
        }
    });
}

function changeClassSize(jqueryClass, width, height) {
    jqueryClass.css({
        'width': width,
        'height': height
    });
}

function initMap() {
    navigator.geolocation.getCurrentPosition(ignite);
}
