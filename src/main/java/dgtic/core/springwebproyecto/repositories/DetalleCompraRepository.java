package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;
import dgtic.core.springwebproyecto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, DetalleCompraId> {
    List<DetalleCompra> findDetalleCompraByDetalleCompraId_Pedido(Pedido pedido);
}
