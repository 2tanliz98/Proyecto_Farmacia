package dgtic.core.springwebproyecto.api.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Integer id;
    private String email;

}
