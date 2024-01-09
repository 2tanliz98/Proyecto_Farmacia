package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.MetodoPago;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    List<Pedido> findAllPedidoByOrderByFechaAsc();
    Page<Pedido> findPedidoByUsuario(Pageable pageable, Usuario usuario);
    List<Pedido> findPedidoByMetodoPago(MetodoPago metodo);
    List<Pedido> findPedidoByTotalLessThanEqual(BigDecimal total);

}
