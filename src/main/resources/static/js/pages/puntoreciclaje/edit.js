afterInit = () => {
    const categories = $('#categories');
    const days = $('#days');
    const categoriesList = categories.data("lista").toLowerCase().split(', ')
    const dayList = days.data("lista").split(',');
    const currentCoords = $('#coordinates').val().split(',');
    categories.val(categoriesList);
    days.val(dayList);
    $('.selectpicker').selectpicker('render');
    moveMap(parseFloat(currentCoords[0]), parseFloat(currentCoords[1]));
}