package dgtic.core.springwebproyecto.api.usuario;

import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegistroUsuarioMapper {

    public UsuarioResponseDTO toDto(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getEmail());
    }

    public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return new Usuario(
                null, usuarioRequestDTO.getNombre(), usuarioRequestDTO.getApellidoPaterno(),
                usuarioRequestDTO.getApellidoMaterno(), usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getPassword(), 1, null,
                usuarioRequestDTO.getAlias(), usuarioRequestDTO.getTelefono());
    }


}
