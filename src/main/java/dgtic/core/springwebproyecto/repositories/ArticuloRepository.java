package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticuloRepository extends JpaRepository<Articulo,Integer> {

    Optional<Articulo> findById(Integer id);
    Page<Articulo> findArticuloByNombreContaining(String query, Pageable pageable);

    Page<Articulo> findByNombreLikeIgnoreCase(String nombre, Pageable pageable);
}
