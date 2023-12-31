package dgtic.core.springwebproyecto.service.tarjeta;

import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TarjetaService {
    Page<Tarjeta> findAll(Pageable pageable);
    void guardar(Tarjeta tarjeta);
    void borrar(Integer id);
    Tarjeta buscarTarjetaId(Integer id);
    Tarjeta buscarTarjetaUsuario(Usuario usuario);
    List<Tarjeta> buscarTarjetas();
}
