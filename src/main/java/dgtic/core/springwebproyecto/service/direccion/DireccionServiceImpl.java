package dgtic.core.springwebproyecto.service.direccion;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.DireccionNotFoundException;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    DireccionRepository direccionRepository;

    @Override
    public Page<Direccion> findAll(Pageable pageable) {
        return direccionRepository.findAll(pageable);
    }

    @Override
    public Direccion guardar(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void borrar(Integer id) {
        direccionRepository.deleteById(id);
    }

    @Override
    public Direccion buscarDireccionId(Integer id) {
        Optional<Direccion> op=direccionRepository.findById(id);
        return op.get();
    }

    @Override
    public Direccion buscarDireccionUsuario(Usuario usuario) {
        Optional<Direccion> op = direccionRepository.findDirectionByUsuario(usuario);
        if(op.isEmpty()){
            throw new DireccionNotFoundException(usuario);
        }
        return  op.get();
    }

    @Override
    public List<Direccion> buscarDireccions() {
        return null;
    }

}
