const initialZoom = 15;
const mapId = "map";
const request = obj => {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open(obj.method || "GET", obj.url);
        if (obj.headers) {
            Object.keys(obj.headers).forEach(key => {
                xhr.setRequestHeader(key, obj.headers[key]);
            });
        }
        xhr.onload = () => {
            if (xhr.status >= 200 && xhr.status < 300) {
                console.log(xhr.response);
                resolve(xhr.response);
            } else {
                reject(xhr.statusText);
            }
        };
        xhr.onerror = () => reject(xhr.statusText);
        xhr.send(obj.body);
    });
};

/**
 *
 * @param {string[]} categories
 * @returns {string}
 */
const iconTemplate = (categories) => {
    return `
    <div class="no-background pin-tooltip">${badgeTemplate(categories, 'primary margin-1')}</div>
    <div class="pin-container flex">
        <img class="pin-image pin-image-size" alt="pin" src="img/map/map_ping_green.svg">    
    </div>   
    `;
}

const badgeTemplate = (days, badgeType) => {
    return days.map(function (day) {
        return '<span class="badge badge-' + badgeType + '">' + day + '</span>'
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
    <div id="siteNotice">${badgeTemplate(dialog.categories, 'primary')}</div>
    <h1 id="firstHeading" class="firstHeading">${dialog.first_heading}</h1>
    <div id="bodyContent">
        <p>${dialog.body_content}</p>
        <p>${dialog.address}</p>
        <p><a href="${dialog.link}">Site</a></p>
        <p>${badgeTemplate(dialog.days, 'secondary')}</p>
        <p>${dialog.schedule}</p>
    </div>
</div>
`;
};

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
 * @param {float[]} coords
 * @returns {Promise<google.maps.InfoWindow>}
 */
const buildInfoWindow = (coords) => {
    console.log(coords);
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
function buildPines(pines, map) {
    pines.forEach((pin) => {
        let marker = new RichMarker({
            position: new google.maps.LatLng(pin.location.coordinates[0], pin.location.coordinates[1]),
            map: map,
            content: iconTemplate(pin.categories),
            title: pin.title,
            shadow: 0
        });
        marker.addListener('click', async function () {
            console.log(pin);
            const infoWindow = await buildInfoWindow(pin.location.coordinates);
            infoWindow.open(map, marker);
        });
    });
}

let ignite = (location) => {
    let browserLat = location.coords.latitude;
    let browserLong = location.coords.longitude;
    let map = new google.maps.Map(document.getElementById(mapId), {
        center: {
            lat: browserLat,
            lng: browserLong
        },
        zoom: initialZoom
    });
    request({url: '/api/pin'})
        .then(data => {
            buildPines(JSON.parse(data), map);
        })
    map.addListener('zoom_changed', () => {
        let pinImageClass = $('.pin-image-size');
        let pinContainer = $('.pin-container');
        let pinTooltip = $('.pin-tooltip');
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
