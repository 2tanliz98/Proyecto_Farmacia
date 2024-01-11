package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.DetalleCompraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, DetalleCompraId> {
}
