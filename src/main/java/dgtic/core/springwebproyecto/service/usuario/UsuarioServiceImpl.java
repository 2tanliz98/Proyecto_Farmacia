package dgtic.core.springwebproyecto.service.usuario;

import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.model.UsuarioAlreadyExistsException;
import dgtic.core.springwebproyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, timeout=5)
    public Usuario registrarUsuario(Usuario usuario){
        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public Usuario altaUsuario(Usuario usuario) {
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return usuario;
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
