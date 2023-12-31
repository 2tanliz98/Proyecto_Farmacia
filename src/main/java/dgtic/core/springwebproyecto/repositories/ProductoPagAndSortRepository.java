package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoPagAndSortRepository extends PagingAndSortingRepository<Producto,Integer> {

}
