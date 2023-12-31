package dgtic.core.springwebproyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
    @EmbeddedId
    private DetalleCompraId detalleCompraId;

    private Integer cantidad;

    @Column(precision = 8, scale = 2)
    private BigDecimal precioTotal;
}
