const emailInput = $('#email');
const validateButton = $('#btn-validate');
const submitButton = $('#btn-submit');
const validateMailPath = '/api/users'

function validateMail() {
    request({
        url: `${validateMailPath}/${emailInput.val()}`
    }).then(
        () => {
            submitButton.attr("disabled", false);
        }
    ).catch(
        () => {
            bindTooltip(validateButton);
            activateTooltip(validateButton);
        }
    );
}

const bindTooltip = (element) => {
    element.popover({
        trigger: 'manual',
        html: true,
        content: '',
        title: 'Categorías',
        placement: 'top',
        template: `
<div class="popover mensaje-contenedor" role="popover">
    <div class="arrow"></div>
    <h5 class="popover-title recy-popover-title fw-600">Email no encontrado</h5>
    <div class="popover-text">
        <span class="text-danger">Pregunta si el usuario tiene otro mail o pide que se haga una cuenta.</span>
    </div>
    <div class="margin-auto w100">
        <a href="#" class="card-link fw-600" id="popover-cerrar">Cerrar</a>
    </div>

</div>
</div>
`
    });
}

const activateTooltip = (element) => {
    element.popover('toggle');
    $('#popover-cerrar').click(() => {
        element.popover('dispose');
    });
}