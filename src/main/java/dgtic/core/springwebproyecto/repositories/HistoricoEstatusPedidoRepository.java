package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.HistoricoEstatus;
import dgtic.core.springwebproyecto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricoEstatusPedidoRepository extends JpaRepository<HistoricoEstatus, Integer> {

    @Query(value = "SELECT h.historicoEstatusId.estatus.nombre FROM HistoricoEstatus h "+
            "WHERE h.historicoEstatusId.pedido = :pedido "
    )
    String findEstatusByPedido(@Param("pedido") Pedido pedido);

}
