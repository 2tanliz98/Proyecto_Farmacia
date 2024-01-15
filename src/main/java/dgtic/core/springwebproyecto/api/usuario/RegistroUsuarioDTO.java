package dgtic.core.springwebproyecto.api.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroUsuarioDTO {

    @NotNull(message="Usuario es requerido para realizar el registro")
    @Valid
    private UsuarioRequestDTO usuario;

    @NotNull(message="Direccion es requerida para realizar el registro")
    @Valid
    private DireccionDTO direccion;

}
