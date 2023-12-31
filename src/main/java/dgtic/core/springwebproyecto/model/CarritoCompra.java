package dgtic.core.springwebproyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "carrito_compra")
public class CarritoCompra {
    @EmbeddedId
    private CarritoCompraId carritoCompraId;

    private Integer cantidad;
}
