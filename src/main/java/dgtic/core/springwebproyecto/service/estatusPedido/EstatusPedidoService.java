package dgtic.core.springwebproyecto.service.estatusPedido;

import dgtic.core.springwebproyecto.model.EstatusPedido;
import dgtic.core.springwebproyecto.model.Pedido;

import java.util.List;

public interface EstatusPedidoService {
    List<EstatusPedido> findAll();
    EstatusPedido findById(Integer id);

}
