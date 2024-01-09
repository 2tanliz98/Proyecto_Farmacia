package dgtic.core.springwebproyecto.service.metodoPago;

import dgtic.core.springwebproyecto.model.MetodoPago;

import java.util.List;

public interface MetodoPagoService {

    List<MetodoPago> findAll();
    MetodoPago findById(Integer id);
}
