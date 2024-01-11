package dgtic.core.springwebproyecto.service.historicoEstatus;

import dgtic.core.springwebproyecto.model.EstatusPedido;
import dgtic.core.springwebproyecto.model.HistoricoEstatus;
import dgtic.core.springwebproyecto.model.Pedido;

import java.util.List;

public interface HistoricoEstatusService {

    String findEstatusByPedido(Pedido pedido);

    void guardarEstatusNuevo(HistoricoEstatus nuevoEstatus);
}
