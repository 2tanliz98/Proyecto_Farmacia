package dgtic.core.springwebproyecto.service.pedido;

import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.SimpleIdGenerator;

import java.util.List;

public interface PedidoService {
    Page<Pedido> findAll(Pageable pageable);
    void borrar(Integer id);
    Pedido buscarPedidoId(Integer id);

    Page<Pedido> findPedidoByUsuario(Pageable pageable, Usuario usuario);

    void guardar(Pedido pedido);
}
