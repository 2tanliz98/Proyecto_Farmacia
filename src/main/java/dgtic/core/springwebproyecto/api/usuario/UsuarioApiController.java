package dgtic.core.springwebproyecto.api.usuario;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioApiController implements UsuarioApi {

    @Autowired
    private RegistroUsuarioMapper mapper;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private DireccionService direccionService;

    @Override
    public UsuarioResponseDTO registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        Usuario usuario = mapper.toUsuario(registroUsuarioDTO.getUsuario());
        Direccion direccion = mapper.toDireccion(registroUsuarioDTO.getDireccion());
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario);
        Direccion direccionCreado = direccionService.guardar(direccion);
        return mapper.toDto(usuarioCreado);
    }

}
