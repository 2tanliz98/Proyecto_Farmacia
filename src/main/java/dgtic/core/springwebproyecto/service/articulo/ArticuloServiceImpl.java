package dgtic.core.springwebproyecto.service.articulo;

import dgtic.core.springwebproyecto.model.Articulo;
import dgtic.core.springwebproyecto.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;
    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> findbyId(Integer id) {
        Optional<Articulo> optional =  articuloRepository.findById(id);
        return optional;
    }

    @Override
    public void update(Articulo articulo) {
        articuloRepository.save(articulo);
    }

}
