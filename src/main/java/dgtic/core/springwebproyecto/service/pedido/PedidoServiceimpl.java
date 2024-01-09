package dgtic.core.springwebproyecto.service.pedido;

import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.repositories.PedidoRepository;
import dgtic.core.springwebproyecto.repositories.PedidosPagAndSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  PedidoServiceimpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidosPagAndSortRepository pageAndSort;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    @Override
    public void borrar(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido buscarPedidoId(Integer id) {
        Optional<Pedido> op=pedidoRepository.findById(id);
        return op.get();
    }

    @Override
    public Page<Pedido> findPedidoByUsuario(Pageable pageable, Usuario usuario) {
        return pedidoRepository.findPedidoByUsuario(pageable, usuario);
    }


}
