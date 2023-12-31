package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    Optional<Direccion> findDirectionByUsuario(Usuario usuario);
}
