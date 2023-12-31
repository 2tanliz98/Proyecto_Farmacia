package dgtic.core.springwebproyecto.service.empresaProductoService;

import dgtic.core.springwebproyecto.model.EmpresaProducto;
import dgtic.core.springwebproyecto.model.Producto;
import dgtic.core.springwebproyecto.repositories.EmpresaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaProductoImpl implements EmpresaProductoService{
    @Autowired
    EmpresaProductoRepository empresaProductoRepository;

    @Override
    public EmpresaProducto findByProducto(Producto producto) {
        return empresaProductoRepository.findEmpresaProductoByProducto(producto);
    }
}
