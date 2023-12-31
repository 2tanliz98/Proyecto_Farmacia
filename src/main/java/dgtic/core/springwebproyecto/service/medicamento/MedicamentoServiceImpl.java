package dgtic.core.springwebproyecto.service.medicamento;

import dgtic.core.springwebproyecto.model.Medicamento;
import dgtic.core.springwebproyecto.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Override
    public List<Medicamento> findAll() {
        return (List<Medicamento>) medicamentoRepository.findAll();
    }

    @Override
    public Medicamento findbyId(Integer id) {
        Optional<Medicamento> optional =  medicamentoRepository.findById(id);
        return optional.get();
    }

}
