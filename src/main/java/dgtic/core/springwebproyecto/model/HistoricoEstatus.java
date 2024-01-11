package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "historico_estatus_pedido")
public class HistoricoEstatus {
    @EmbeddedId
    private HistoricoEstatusId historicoEstatusId; //pedido + estatus

    @Column(name="fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = "yyyy-MM-dd")
    private Date fecha;

}
