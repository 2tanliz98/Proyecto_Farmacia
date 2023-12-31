package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    Tarjeta findTarjetaByUsuario(Usuario usuario);
}
