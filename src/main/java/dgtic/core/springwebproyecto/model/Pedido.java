package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name="id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidoId;

    @Column(name="fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = "yyyy-MM-dd")
    private Date fecha;

    @Column(precision = 6, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name="metodo_pago")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + pedidoId +
                "\n fecha=" + fecha +
                "\n total=" + total +
                "\n metodoPago=" + metodoPago.toString() +
                "\n usuario=" + usuario +
                '}';
    }
}
