package dgtic.core.springwebproyecto.validation;

import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario=(Usuario)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotBlank.usuario.nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"apPaterno","NotBlank.usuario.apPaterno");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotBlank.usuario.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"alias","NotBlank.usuario.alias");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotBlank.usuario.password");
    }

}

