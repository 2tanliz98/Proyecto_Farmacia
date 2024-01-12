package dgtic.core.springwebproyecto.service.detalleCompra;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.repositories.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService{

    @Autowired
    DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> findAll() {
        return (List<DetalleCompra>) detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra findById(DetalleCompraId id) {
        Optional<DetalleCompra> op = detalleCompraRepository.findById(id);
        return op.isEmpty()? null: op.get();
    }

    @Override
    public void save(DetalleCompra dc) {
        detalleCompraRepository.save(dc);
    }

    @Override
    public List<DetalleCompra> findDetalleCompraByDetalleCompraId_Pedido(Pedido pedido) {
        return detalleCompraRepository.findDetalleCompraByDetalleCompraId_Pedido(pedido);
    }
}
