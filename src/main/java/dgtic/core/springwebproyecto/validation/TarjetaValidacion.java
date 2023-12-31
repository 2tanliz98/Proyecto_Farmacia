package dgtic.core.springwebproyecto.validation;

import dgtic.core.springwebproyecto.model.Tarjeta;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TarjetaValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Tarjeta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tarjeta tarjeta = (Tarjeta)target;
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"date","NotBlank.tarjeta.date");

    }


}
