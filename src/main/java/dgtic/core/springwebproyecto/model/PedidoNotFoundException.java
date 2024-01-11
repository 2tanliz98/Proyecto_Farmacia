package dgtic.core.springwebproyecto.model;

public class PedidoNotFoundException extends RuntimeException{
    public PedidoNotFoundException(Pedido pedido) {
        super("No se encuentra pedido para el id: " + pedido.getPedidoId());
    }
}
