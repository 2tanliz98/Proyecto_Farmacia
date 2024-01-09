package dgtic.core.springwebproyecto.service.metodoPago;

import dgtic.core.springwebproyecto.model.MetodoPago;
import dgtic.core.springwebproyecto.repositories.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService{
    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public MetodoPago findById(Integer id) {
        Optional<MetodoPago> op = metodoPagoRepository.findById(id);
        return op.isEmpty()? null: op.get();
    }
}
