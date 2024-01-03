package dgtic.core.springwebproyecto.service.usuario;

import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {
    Page<Usuario> findAll(Pageable pageable);
    void borrar(Integer id);
    Usuario buscarUsuarioId(Integer id);
    List<Usuario> buscarUsuarios();
    Usuario registrarUsuario(Usuario usuario);
    Usuario altaUsuario(Usuario usuario);
}
