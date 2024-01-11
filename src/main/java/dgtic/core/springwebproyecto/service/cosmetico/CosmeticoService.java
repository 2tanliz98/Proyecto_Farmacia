package dgtic.core.springwebproyecto.service.cosmetico;

import dgtic.core.springwebproyecto.model.Cosmetico;
import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CosmeticoService {
    List<Cosmetico> findAll();
    Cosmetico findbyId(Integer id);
    Page<Cosmetico> findAllPagination(Pageable pageable);
}
