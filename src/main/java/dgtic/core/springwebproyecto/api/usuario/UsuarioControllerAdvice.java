package dgtic.core.springwebproyecto.api.usuario;


import dgtic.core.springwebproyecto.model.UsuarioAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("unam.diplomado.pixup.usuario.api")
public class UsuarioControllerAdvice {

    @ExceptionHandler(UsuarioAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private ErrorResponse usuarioAlreadyExistsHandler(
            UsuarioAlreadyExistsException exception) {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "BUSINESS_RULE",
                exception.getMessage());
    }


}
