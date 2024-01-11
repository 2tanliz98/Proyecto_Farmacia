package dgtic.core.springwebproyecto.service.estatusPedido;

import dgtic.core.springwebproyecto.model.EstatusPedido;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.repositories.EstatusPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EstatusPedidoServiceImpl implements EstatusPedidoService{

    @Autowired
    EstatusPedidoRepository estatusPedidoRepository;

    @Override
    public List<EstatusPedido> findAll() {
        return estatusPedidoRepository.findAll();
    }

    @Override
    public EstatusPedido findById(Integer id) {
        Optional<EstatusPedido> op = estatusPedidoRepository.findById(id);
        return op.isEmpty()? null: op.get();
    }

}
