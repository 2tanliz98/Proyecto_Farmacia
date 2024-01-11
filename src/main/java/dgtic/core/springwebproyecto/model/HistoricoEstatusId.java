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
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class HistoricoEstatusId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "estatus")
    private EstatusPedido estatus;
}
