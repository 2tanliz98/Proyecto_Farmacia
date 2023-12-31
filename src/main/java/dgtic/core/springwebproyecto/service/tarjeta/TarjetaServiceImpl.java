package dgtic.core.springwebproyecto.service.tarjeta;

import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    TarjetaRepository tarjetaRepository;

    @Override
    public Page<Tarjeta> findAll(Pageable pageable) {
        return tarjetaRepository.findAll(pageable);
    }

    @Override
    public void guardar(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
    }

    @Override
    public void borrar(Integer id) {
        tarjetaRepository.deleteById(id);
    }

    @Override
    public Tarjeta buscarTarjetaId(Integer id) {
        Optional<Tarjeta> op=tarjetaRepository.findById(id);
        return op.get();
    }

    @Override
    public Tarjeta buscarTarjetaUsuario(Usuario usuario) {
        return tarjetaRepository.findTarjetaByUsuario(usuario);
    }

    @Override
    public List<Tarjeta> buscarTarjetas() {
        return null;
    }

}
