package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "direccion")
public class Direccion {
    @TableGenerator(name="Dir_Gen",
            table="id_gen",
            pkColumnName="gen_name",
            valueColumnName="gen_val",
            initialValue = 100,
            pkColumnValue = "dir_gen",
            allocationSize = 1)
    @Id
    @Column(name="gen_val")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Dir_Gen")
    private Integer id;
    @Column(length = 50)
    private String calle;
    @Column
    //@Positive(message = "Ingrese un número válido")
    @Pattern(regexp = "[0-9]{1,6}",message = "Número no válido")
    private String numero;
    @Column(name = "codigo_postal", length = 5)
    @Pattern(regexp = "[0-9]{5}",message = "Código Postal no válido")
    private String codigoPostal;
    @Column(length = 50)
    private String colonia;
    @Column(length = 50)
    private String municipio;
    @Column(name="entidad_federativa", length=50)
    private String estado;

    @OneToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                "\n calle='" + calle + '\'' +
                "\n numero=" + numero +
                "\n codigo_postal='" + codigoPostal + '\'' +
                "\n colonia='" + colonia + '\'' +
                "\n municipio='" + municipio + '\'' +
                "\n estado='" + estado + '\'' +
                "\n usuario='" + usuario.toString() + '\'' +
                '}';
    }
}
