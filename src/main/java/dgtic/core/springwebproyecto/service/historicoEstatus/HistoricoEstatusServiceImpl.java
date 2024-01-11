package dgtic.core.springwebproyecto.service.historicoEstatus;

import dgtic.core.springwebproyecto.model.*;
import dgtic.core.springwebproyecto.repositories.HistoricoEstatusPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoricoEstatusServiceImpl implements HistoricoEstatusService{
    @Autowired
    HistoricoEstatusPedidoRepository historicoRepository;

    @Override
    public String findEstatusByPedido(Pedido pedido) {
        return historicoRepository.findEstatusByPedido(pedido);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, timeout=6)
    public void guardarEstatusNuevo(HistoricoEstatus nuevoEstatus) {
        Pedido pedido = nuevoEstatus.getHistoricoEstatusId().getPedido();
        EstatusPedido estatusPedido = nuevoEstatus.getHistoricoEstatusId().getEstatus();
        if (pedido == null){
            throw new PedidoNotFoundException(pedido);
        }
        if (estatusPedido == null){
            throw new EstatusPedidoNotFoundException(estatusPedido);
        }
        historicoRepository.save(nuevoEstatus);
    }
}
