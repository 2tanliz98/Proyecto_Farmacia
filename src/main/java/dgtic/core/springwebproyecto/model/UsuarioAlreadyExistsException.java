package dgtic.core.springwebproyecto.model;

public class UsuarioAlreadyExistsException extends RuntimeException{

    public UsuarioAlreadyExistsException(String email) {
        super("Ya existe un usuario registrado con email: " + email);
    }

}
