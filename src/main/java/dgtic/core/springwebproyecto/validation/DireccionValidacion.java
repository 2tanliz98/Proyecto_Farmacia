package dgtic.core.springwebproyecto.validation;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DireccionValidacion implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Direccion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Direccion direccion=(Direccion) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"calle","NotBlank.direccion.calle");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"numero","NotBlank.direccion.numero");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"codigoPostal","NotBlank.direccion.codigoPostal");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"colonia","NotBlank.direccion.colonia");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"municipio","NotBlank.direccion.municipio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"estado","NotBlank.direccion.estado");
    }
}
