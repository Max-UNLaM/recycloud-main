const mapButtonActiveClass = 'active';
const backgroundColorDataName = 'background';
const floatNumberMatch = /[-+]?([0-9]*\.[0-9]+|[0-9]+)/g;

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
    if (category === null || category === '' || button.text().toLowerCase() === category.toLowerCase()) {
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
    const color = button.data(backgroundColorDataName);
    color.currentAlpha = 1;
    button.css('background-color', color.getCssCurrentProperty());
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
    categoryList = categoryList.filter(category => category !== button.text().toLowerCase());
}

buttons.click(function () {
    buttonSwitcher($(this));
    renewPines(categoryList.join());
});

fillCategoryList(() => {
});