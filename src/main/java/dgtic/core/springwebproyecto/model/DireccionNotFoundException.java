package dgtic.core.springwebproyecto.model;

public class DireccionNotFoundException extends RuntimeException{

    public DireccionNotFoundException(Usuario usuario){
        super("No se encontró dirección de usuario: "+usuario.getNombre());
    }
}
