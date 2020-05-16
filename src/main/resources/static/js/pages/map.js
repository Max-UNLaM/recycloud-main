const initialZoom = 16;
const paddleIcons = "http://maps.google.com/mapfiles/kml/paddle";
const mapId = "map";

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

const icons = [{
    bronze: {
        icon: paddleIcons + "/red_blank.png"
    },
    plastic: {
        icon: paddleIcons + "/purple_blank.png"
    },
    top: {
        icon: paddleIcons + "/purple_star.png"
    },
    metal: {
        icon: paddleIcons + "/blue_blank.png"
    },
    bottles: {
        icon: paddleIcons + "/tlblu_diamond.png"
    },
    bateries: {
        icon: paddleIcons + "/yellow_blank.png"
    },
    paperboard: {
        icon: paddleIcons + "/white_diamond.png"
    },
    electronic: {
        icon: paddleIcons + "/yellow_diamond.png"
    },
    glass: {
        icon: paddleIcons + "/tlblu_blank.png"
    },
    textiles: {
        icon: paddleIcons + "/orange_blank.png"
    },
    other: {
        icon: paddleIcons + "/blue_blank.png"
    }
}]

let features = [{
    title: "Tu Vieja",
    coords: {
        lat: -34.695922,
        lng: -58.604702
    },
    icon: {
        name: "Alfajor",
        location: "img/"
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

let map;
let ignite = (location) => {
    let browserLat = location.coords.latitude;
    let browserLong = location.coords.longitude;
    map = new google.maps.Map(document.getElementById(mapId), {
        center: {lat: browserLat, lng: browserLong},
        zoom: initialZoom
    });
    features.forEach((feature) => {
        let infoWindow = new google.maps.InfoWindow({
            content: baseTemplate(feature.dialog)
        });

        let marker = new google.maps.Marker({
            position: feature.coords,
            map: map,
            icon: feature.icon.location,
            title: feature.title
        });
        marker.addListener('click', function () {
            infoWindow.open(map, marker);
        });
    });
}
let geolocation = navigator.geolocation.getCurrentPosition(ignite);