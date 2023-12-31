package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.EmpresaProducto;
import dgtic.core.springwebproyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaProductoRepository extends JpaRepository<EmpresaProducto, Integer> {

    EmpresaProducto findEmpresaProductoByProducto(Producto producto);

}
