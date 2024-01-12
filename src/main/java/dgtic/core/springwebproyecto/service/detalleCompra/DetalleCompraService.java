package dgtic.core.springwebproyecto.service.detalleCompra;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;
import dgtic.core.springwebproyecto.model.Pedido;

import javax.lang.model.element.PackageElement;
import java.util.List;

public interface DetalleCompraService {

    List<DetalleCompra> findAll();

    DetalleCompra findById(DetalleCompraId id);

    void save(DetalleCompra dc);

    List<DetalleCompra> findDetalleCompraByDetalleCompraId_Pedido(Pedido pedido);

}
