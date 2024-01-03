package dgtic.core.springwebproyecto.api.usuario;

import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioApiController implements UsuarioApi {

    @Autowired
    private RegistroUsuarioMapper mapper;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UsuarioResponseDTO registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        Usuario usuario = mapper.toUsuario(registroUsuarioDTO.getUsuario());
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario);
        return mapper.toDto(usuarioCreado);
    }

}
