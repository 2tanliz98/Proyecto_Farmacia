package dgtic.core.springwebproyecto.controller.articulo;

import dgtic.core.springwebproyecto.util.ErrorResponse;
import dgtic.core.springwebproyecto.model.EstatusPedidoNotFoundException;
import dgtic.core.springwebproyecto.model.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArticuloControllerAdvice {

    @ExceptionHandler(PedidoNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorResponse pedidoNotFoundHandler(
            PedidoNotFoundException exception) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "NOT FOUND PEDIDO",
                exception.getMessage());
    }
    @ExceptionHandler(EstatusPedidoNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorResponse estatusNotFoundHandler(
            EstatusPedidoNotFoundException exception) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "NOT FOUND STATUS",
                exception.getMessage());
    }


}
