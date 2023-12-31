package dgtic.core.springwebproyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "cat_farmacos")
@DiscriminatorValue("1")
public class Medicamento extends Producto{
    @Column(name = "ingrediente_activo")
    private String ingredienteActivo;

    public Medicamento(){}
    public Medicamento( String nombre, String marca, String ingredienteActivo) {
        super( nombre, marca);
        this.ingredienteActivo = ingredienteActivo;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "ingredienteActivo='" + ingredienteActivo + '\'' +
                "} " + super.toString();
    }
}
