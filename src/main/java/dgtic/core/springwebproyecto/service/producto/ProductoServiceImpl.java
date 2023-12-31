package dgtic.core.springwebproyecto.service.producto;

import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.model.Producto;
import dgtic.core.springwebproyecto.repositories.MedicamentoRepository;
import dgtic.core.springwebproyecto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findbyId(Integer id) {
        Optional<Producto> optional =  productoRepository.findById(id);
        return optional;
    }

}
