$(document).ready(function () {
    $('input[name="metodoPago"]').change(function () {
        var metodoPagoId = $('input[name="metodoPago"]:checked').val();

        if (metodoPagoId === '4') {
            $('#tarjetaTable').hide();
            verificarEstadoBoton();
        } else {
            $('#tarjetaTable').show();
            $('input[name="tarjetaSeleccionada"]').change(function () {
                verificarEstadoBoton();
            });
        }
    });

    // Verificar el estado inicial al cargar la página
    verificarEstadoBoton();

    // Botón de enviar
    $('#botonEnviar').click(function (event) {
        var metodoPago = $('input[name="metodoPago"]:checked').val();
        var tarjeta = $('input[name="tarjetaSeleccionada"]:checked').val();

        if (metodoPago === '4' || (metodoPago !== '4' && tarjeta !== undefined)) {
            var formulario = $('#formulario');
            formulario.submit();
        } else {
            event.preventDefault();
            alert('Por favor, seleccione un método de pago y una tarjeta.');
        }
    });
});

// Función para verificar el estado de los botones
function verificarEstadoBoton() {
    var metodoPagoId = $('input[name="metodoPago"]:checked').val();
    var tarjetaSeleccionada = $('input[name="tarjetaSeleccionada"]:checked').val();

    if (metodoPagoId === '4' || (metodoPagoId !== '4' && tarjetaSeleccionada !== undefined)) {
        $('#botonEnviar').prop('disabled', false);
    } else {
        $('#botonEnviar').prop('disabled', true);
    }
}