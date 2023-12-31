package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Medicamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {

    List<Medicamento> findMedicamentoByNombre(String med);
    List<Medicamento> findMedicamentoByMarca(String marca);
    List<Medicamento> findMedicamentoByIngredienteActivo(String activo);

}
