package dgtic.core.springwebproyecto.service.articulo;

import dgtic.core.springwebproyecto.model.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    List<Articulo> findAll();
    Optional<Articulo> findbyId(Integer id);

    void update(Articulo articulo);
}
