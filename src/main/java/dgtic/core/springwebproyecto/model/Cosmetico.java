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
@Table(name = "cat_cosmeticos")
@DiscriminatorValue("2")
public class Cosmetico extends Articulo{
    @Column(name = "tono_color")
    private String tonoColor;

    public Cosmetico(){}
    public Cosmetico(String nombre, String marca, String tonoColor) {
        super( nombre, marca);
        this.tonoColor = tonoColor;
    }

    @Override
    public String toString() {
        return "Cosmetico{" +
                "tonoColor='" + tonoColor + '\'' +
                "} " + super.toString();
    }
}
