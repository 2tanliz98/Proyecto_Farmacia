package dgtic.core.springwebproyecto.service.empresaProductoService;

import dgtic.core.springwebproyecto.model.EmpresaProducto;
import dgtic.core.springwebproyecto.model.Producto;

public interface EmpresaProductoService {

    EmpresaProducto findByProducto(Producto producto);
}
