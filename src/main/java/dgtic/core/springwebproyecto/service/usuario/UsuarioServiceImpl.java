package dgtic.core.springwebproyecto.service.usuario;

import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void borrar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscarUsuarioId(Integer id) {
        Optional<Usuario> op=usuarioRepository.findById(id);
        return op.get();
    }


    @Override
    public List<Usuario> buscarUsuarios() {
        return null;
    }

}
