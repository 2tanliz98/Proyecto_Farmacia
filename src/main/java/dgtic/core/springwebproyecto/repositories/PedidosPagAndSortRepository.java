package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Articulo;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PedidosPagAndSortRepository extends PagingAndSortingRepository<Articulo,Integer> {

//    @Query("SELECT p FROM Pedido p WHERE p.usuario = :usuario")
//    Page<Pedido> findPedidoByUsuario(@Param("usuario") Usuario usuario);
}
