package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "empresa_producto")
public class EmpresaProducto {
    @Id
    @Column(name = "id_empresa_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer unidades;

    @Column(precision = 6, scale = 2)
    private BigDecimal  precio;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    @Override
    public String toString() {
        return "EmpresaProducto{" +
                "id=" + id +
                ", unidades=" + unidades +
                ", precio=" + precio +
                ", empresa=" + empresa +
                ", producto=" + producto +
                '}';
    }
}
