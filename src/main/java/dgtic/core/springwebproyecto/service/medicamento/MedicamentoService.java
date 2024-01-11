package dgtic.core.springwebproyecto.service.medicamento;

import dgtic.core.springwebproyecto.model.Cosmetico;
import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    List<Medicamento> findAll();
    Medicamento findbyId(Integer id);

    Page<Medicamento> findAllPagination(Pageable pageable);
}
