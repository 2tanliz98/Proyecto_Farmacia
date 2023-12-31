package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_metodo_pago")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;

    @Override
    public String toString() {
        return "MetodoPago{" +
                "id=" + id +
                "\n nombre='" + nombre + '\'' +
                "\n descripcion='" + descripcion + '\'' +
                '}';
    }
}
