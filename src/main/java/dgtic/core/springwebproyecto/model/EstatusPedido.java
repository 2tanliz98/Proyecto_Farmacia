package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "estatus")
public class EstatusPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estatus")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

}
