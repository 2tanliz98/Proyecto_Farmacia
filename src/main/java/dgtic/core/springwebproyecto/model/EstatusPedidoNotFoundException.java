package dgtic.core.springwebproyecto.model;

public class EstatusPedidoNotFoundException extends RuntimeException{
    public EstatusPedidoNotFoundException(EstatusPedido estatusPedido) {
        super("No se encuentra estatus para el id: " + estatusPedido.getId());
    }
}
