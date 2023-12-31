package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Articulo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticuloPagAndSortRepository extends PagingAndSortingRepository<Articulo,Integer> {

}
