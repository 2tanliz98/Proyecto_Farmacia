package dgtic.core.springwebproyecto.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class CarritoCompraId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

}

