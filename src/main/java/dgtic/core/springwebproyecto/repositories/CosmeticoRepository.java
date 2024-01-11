package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Cosmetico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CosmeticoRepository extends CrudRepository<Cosmetico,Integer> {

    List<Cosmetico> findAllCosmeticoByNombre(String cos);
    List<Cosmetico> findAllCosmeticoByMarca(String marca);
    List<Cosmetico> findCosmeticoByTonoColor(String color);
    Page<Cosmetico> findAll(Pageable pageable);


}
