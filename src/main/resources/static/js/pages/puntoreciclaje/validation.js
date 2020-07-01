// Wait for the DOM to be ready
$(function () {
    $.validator.addMethod("lowerThan", function (value, element) {
            return parseInt($("#end_hour").val()) > parseInt($("#begin_hour").val());
        }, "* La hora de cierre tiene que ser posterior a la de apertura"
    );
    // Initialize form validation on the registration form.
    // It has the name attribute "registration"
    $("form[name='crear']").validate({
        // Specify validation rules
        // Specify validation error messages
        ignore: ".ignore",
        rules: {
            title: {
                required: true
            },
            address: {
                required: true
            },
            content: {
                required: true
            },
            endHour: {
                lowerThan: true
            },
            coordinates: {
                required: true,
            }

        },
        messages: {
            title: "Escriba un nombre",
            address: "Escriba una dirección",
            city: "",
            province: "",
            content: "Escriba una descripción",
            days: "",
            categories: "",
            coordinates: "Ubique su punto en el mapa"
        },
        errorPlacement: function(error, element) {
            const placement = $(element).data('error');
            if (placement) {
                console.log(error);
                $(placement).append(error)
            } else {
                error.insertAfter(element);
            }
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function (form) {
            form.submit();
        }
    });

});
