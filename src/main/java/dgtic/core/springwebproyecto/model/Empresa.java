package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String direccion;

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
