package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;
import org.springframework.data.repository.CrudRepository;

public interface DetalleCompraRepository extends CrudRepository<DetalleCompra, DetalleCompraId> {
}
