package dgtic.core.springwebproyecto.api.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String email;
    private String alias;
    private String telefono;

}
