package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticuloRepository extends JpaRepository<Articulo,Integer> {

    Optional<Articulo> findById(Integer id);

}
