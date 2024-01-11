package dgtic.core.springwebproyecto.service.articulo;

import dgtic.core.springwebproyecto.model.Articulo;
import dgtic.core.springwebproyecto.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;
    @Override
    public Page<Articulo> findAll(Pageable pageable) {
        return articuloRepository.findAll(pageable);
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

    @Override
    public Page<Articulo> findArticuloByNombreContaining(String query, Pageable pageable) {
        return articuloRepository.findArticuloByNombreContaining(query, pageable);
    }

    @Override
    public Page<Articulo> findByNombreLikeIgnoreCase(String nombre, Pageable pageable){
        return articuloRepository.findByNombreLikeIgnoreCase(nombre, pageable);
    }

}
