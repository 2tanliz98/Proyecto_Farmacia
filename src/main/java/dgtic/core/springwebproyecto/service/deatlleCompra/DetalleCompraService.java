package dgtic.core.springwebproyecto.service.deatlleCompra;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;

import java.util.List;
import java.util.Optional;

public interface DetalleCompraService {

    List<DetalleCompra> findAll();

    DetalleCompra findById(DetalleCompraId id);

    void save(DetalleCompra dc);

}
