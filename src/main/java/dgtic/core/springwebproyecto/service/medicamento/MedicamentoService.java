package dgtic.core.springwebproyecto.service.medicamento;

import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    List<Medicamento> findAll();
    Medicamento findbyId(Integer id);
}
