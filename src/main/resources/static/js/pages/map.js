const initialZoom = 15;
const mapId = "map";

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

const baseTemplate = (dialog) => {
    return `
<div id="content">
    <div id="siteNotice">${badgeTemplate(dialog.categories, 'primary')}</div>
    <h1 id="firstHeading" class="firstHeading">${dialog.firstHeading}</h1>
    <div id="bodyContent">
        <p>${dialog.bodyContent}</p>
        <p>${dialog.address}</p>
        <p><a href="${dialog.link}">Site</a></p>
        <p>${badgeTemplate(dialog.days, 'secondary')}</p>
        <p>${dialog.schedule}</p>
    </div>
</div>
`;
};

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

let features = [
    {
        title: "Eco Botellas",
        coords: {
            lat: -34.0717139,
            lng: -60.1096311
        },
        categories: ["ECO BOTELLAS, PLÁSTICO"],
        dialog: {
            address: 'Av. Dr. Carlos Merlassino 1099, Arrecifes',
            categories: ["ECO BOTELLAS, PLÁSTICO"],
            firstHeading: "Eco Botellas",
            bodyContent: "Botellas de tipo PET rellenas de plásticos de un solo uso. Plásticos que cotidianamente usamos una sola vez y luego desechamos, debe estar compactado todo este plástico para que entre la mayor cantidad en 1 sola botella",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "De 9 a 12 y de 16 a 20",
            link: "www.prueba.com"
        }
    },
    {
        title: "Llená tu botella",
        coords: {
            lat: -34.6510276,
            lng: -58.6238583
        },
        dialog: {
            categories: ["ECO BOTELLAS", "PLÁSTICO"],
            firstHeading: "Llená tu Botella",
            bodyContent: "Este es un pin de prueba",
            days: ["sábados", "martes"],
            schedule: "de 15 a 17",
            link: "www.prueba.com"
        }
    },
    {
        title: "Padua Recicla",
        coords: {
            lat: -34.6801923,
            lng: -58.719233
        },
        dialog: {
            categories: ["CARTÓN", "VIDRIO", "PAPELES", "TAPITAS"],
            firstHeading: "Padua Recicla",
            bodyContent: "Recolectamos tapitas plásticas, papeles blancos y de color, cartón, diarios y revistas. Los acoplamos y enviamos a reciclar.\n" +
                "Los papeles deben estar separados, por un lado los blancos (tickets, prospectos de remedios, hojas de cuadernos y carpetas, fotocopias, apuntes, agendas, etc.) y por otro los de color (cajitas de remedios, folletos de color, cartulinas, cajas de productos alimenticios o de limpieza, etc.)",
            days: ["miércoles", "sábados"],
            schedule: "Mie: 17 a 18, Sab: 12 a 13",
            link: "www.prueba.com"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6475677,
            lng: -58.6208252
        },
        dialog: {
            address: 'Independencia 84, Morón',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Morón",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6475677,
            lng: -58.6208252
        },
        dialog: {
            address: 'Estrada 17, Haedo',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Morón",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6064186,
            lng: -58.5988777
        },
        dialog: {
            address: 'Pedernera 280, El Palomar.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Palomar",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6532363,
            lng: -58.6434944
        },
        dialog: {
            address: 'Martín Irigoyen 525, Castelar Centro.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Castelar",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6835629,
            lng: -58.6627587
        },
        dialog: {
            address: 'Williams Morris 3520, Castelar Sur.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Castelar",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6532363,
            lng: -58.6434944
        },
        dialog: {
            address: 'Martín Irigoyen 525, Castelar Centro.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor Castelar",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.689439,
            lng: -58.6383319
        },
        dialog: {
            address: 'Baradero 1340, Morón sur.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Morón sur",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    },
    {
        title: "Morón Verde",
        coords: {
            lat: -34.6379719,
            lng: -58.5700491
        },
        dialog: {
            address: 'Solier 417, Villa Sarmiento.',
            categories: ["CARTÓN", "VIDRIO", "PLÁSTICOS"],
            firstHeading: "Contenedor UGC Villa Sarmiento",
            bodyContent: "Podés llevar los residuos separados desde tu casa a los contenedores ubicados en cada UGC y en la Reserva Natural Urbana. Acordate de ir en el horario indicado y no dejar la basura fuera del contenedor. Para dejar el aceite y la ropausá los puntos correspondientes.",
            days: ["lunes", "martes", "miércoles", "jueves", "viernes"],
            schedule: "8 a 15 horas",
            link: "http://www.moron.gob.ar/puntos-de-recepcion/"
        }
    }
];

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
    map.addListener('zoom_changed', () => {
        let pinImageClass = $('.pin-image-size');
        let pinContainer = $('.pin-container');
        let pinTooltip = $('.pin-tooltip');
        console.log(map.zoom);
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
