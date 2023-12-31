package dgtic.core.springwebproyecto.service.cosmetico;

import dgtic.core.springwebproyecto.model.Cosmetico;
import dgtic.core.springwebproyecto.model.Articulo;
import dgtic.core.springwebproyecto.repositories.CosmeticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticoServiceImpl implements CosmeticoService {
    @Autowired
    CosmeticoRepository cosmeticoRepository;

    @Override
    public List<Cosmetico> findAll() {
        return (List<Cosmetico> ) cosmeticoRepository.findAll();
    }

    @Override
    public Cosmetico findbyId(Integer id) {
        Optional<Cosmetico> optional =  cosmeticoRepository.findById(id);
        return optional.get();
    }
}
