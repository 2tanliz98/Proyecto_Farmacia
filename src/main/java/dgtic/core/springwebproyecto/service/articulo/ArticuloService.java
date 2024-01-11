package dgtic.core.springwebproyecto.service.articulo;

import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    Page<Articulo> findAll(Pageable pageable);
    Optional<Articulo> findbyId(Integer id);
    void update(Articulo articulo);
    Page<Articulo> findArticuloByNombreContaining(String query, Pageable pageable);

    Page<Articulo> findByNombreLikeIgnoreCase(String nombre, Pageable pageable);
}
