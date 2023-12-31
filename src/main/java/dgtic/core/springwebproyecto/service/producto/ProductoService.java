package dgtic.core.springwebproyecto.service.producto;

import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findbyId(Integer id);
}
