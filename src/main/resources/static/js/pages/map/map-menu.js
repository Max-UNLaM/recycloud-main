const mapButtonActiveClass = 'btn-active';
const backgroundColorDataName = 'background';
const fontColorDataName = 'color';
const enableTooltipKey = 'recycloud-enable-tooltip';
const floatNumberMatch = /[-+]?([0-9]*\.[0-9]+|[0-9]+)/g;
const localStorage = window.localStorage;
const disabled = 'disabled';

let categoryList = [];
const buttons = $('.btn-map');

const renewPines = (categories) => {
    mapHandler.updateMap(`${pinBaseUrl}?categories=${categories.toUpperCase()}`);
}

class RgbaColor {
    red = '';
    green = '';
    blue = '';
    alpha = '';
    currentAlpha = '';
    buildColor = (rgba) => {
        let rgbaList = rgba.match(floatNumberMatch);
        this.red = rgbaList[0];
        this.green = rgbaList[1];
        this.blue = rgbaList[2];
        this.alpha = rgbaList[3];
        this.currentAlpha = this.alpha;
    };
    getCssCurrentProperty = () => {
        return `rgba(${this.red}, ${this.green}, ${this.blue}, ${this.currentAlpha})`;
    };
    getCssDefaultProperty = () => {
        return `rgba(${this.red}, ${this.green}, ${this.blue}, ${this.alpha})`;
    };
}


const fillCategoryList = (afterCall) => {
    const category = params.get(categoryKey);
    if (category !== null) {
        categoryList.push(category.toLowerCase());
    }
    buttons.each(function (i, item) {
        buttonIterate($(item), category)
    });
    afterCall();
}

const buttonIterate = (button, category) => {
    let rgba = new RgbaColor();
    rgba.buildColor(button.css('background-color'));
    button.data(backgroundColorDataName, rgba);
    button.data(fontColorDataName, button.css('color'));
    if (category != null && button.text().toLowerCase() === category.toLowerCase()) {
        buttonEnabler(button);
    }
}

const buttonSwitcher = (button) => {
    if (button.attr('class').includes(mapButtonActiveClass)) {
        buttonDisabler(button);
    } else {
        buttonEnabler(button);
    }
}

const buttonEnabler = (button) => {
    button.addClass(mapButtonActiveClass);
    const backgroundColor = button.data(backgroundColorDataName);
    backgroundColor.currentAlpha = 1;
    button.css('background-color', backgroundColor.getCssCurrentProperty());
    button.css('color', 'FFFF00');
    categoryList.push(button.text().toLowerCase());
}

/**
 *
 * @param button
 */
const buttonDisabler = (button) => {
    const color = button.data(backgroundColorDataName);
    button.removeClass(mapButtonActiveClass);
    button.css('background-color', color.getCssDefaultProperty());
    button.css('color', button.data(fontColorDataName));
    categoryList = categoryList.filter(category => category !== button.text().toLowerCase());
}

const bindTooltip = (element) => {
    element.popover({
        trigger: 'manual',
        html: true,
        content: '',
        title: 'Categorías',
        placement: 'right',
        template: `
<div class="popover" role="popover">
    <div class="arrow"></div>
    <h5 class="popover-title recy-popover-title">Categorías</h5>
    <div class="popover-text">
        ¡Elegí los tipos de reciclaje acá para ver dónde dejarlos!
    </div>
    <a href="#" class="card-link" id="popover-cerrar">Cerrar</a>
    <a href="#" class="card-link" id="popover-no-volver">No volver a mostrar</a>
</div>
</div>
`
    });
}

const activateTooltip = (element) => {
    setTimeout(function () {
        element.popover('toggle');
        $('#popover-cerrar').click(() => {
            element.popover('dispose');
        });
        $('#popover-no-volver').click(() => {
            element.popover('dispose');
            localStorage.setItem(enableTooltipKey, disabled);
        })
    }, 2000);
}

const enableTooltip = () => {
    if (localStorage.getItem(enableTooltipKey) === disabled) {
        return;
    }
    const menu = $('#vertical-menu');
    bindTooltip(menu);
    activateTooltip(menu);
}

buttons.click(function () {
    buttonSwitcher($(this));
    renewPines(categoryList.join());
});

fillCategoryList(() => {
    enableTooltip();
});

