package dgtic.core.springwebproyecto.service.direccion;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DireccionService {
    Page<Direccion> findAll(Pageable pageable);
    Direccion guardar(Direccion direccion);
    void borrar(Integer id);
    Direccion buscarDireccionId(Integer id);
    Direccion buscarDireccionUsuario(Usuario usuario);
    List<Direccion> buscarDireccions();
}
