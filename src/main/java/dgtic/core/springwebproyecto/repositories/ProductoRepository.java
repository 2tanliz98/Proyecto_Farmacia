package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    Optional<Producto> findById(Integer id);

}
