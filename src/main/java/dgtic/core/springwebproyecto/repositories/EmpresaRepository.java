package dgtic.core.springwebproyecto.repositories;

import dgtic.core.springwebproyecto.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT  e.nombre, COUNT(ep.producto) AS total_productos FROM empresa_producto ep " +
            "JOIN empresa e " +
            "ON e.id_empresa = ep.empresa " +
            "WHERE ep.empresa = :id " +
            "GROUP BY ep.empresa",
            nativeQuery = true
    )
    List<Object[]> obtenerTotalProductosPorEmpresa(@Param("id") Integer id);

    @Query(value = "SELECT  e.nombre, p.nombre  FROM empresa_producto ep " +
            "JOIN empresa e " +
            "ON e.id_empresa = ep.empresa " +
            "JOIN producto p " +
            "ON ep.producto = p.id_producto " +
            "WHERE ep.empresa = :id ",
            nativeQuery = true
    )
    List<Object[]> obtenerProductosPorEmpresa(@Param("id") Integer id);

    @Query(value = "SELECT e.nombre, p.marca, p.nombre, ep.costo " +
            "FROM empresa_producto ep " +
            "JOIN empresa e " +
            "ON e.id_empresa = ep.empresa " +
            "JOIN producto p " +
            "ON ep.producto = p.id_producto " +
            "WHERE p.producto_tipo = :tipo ",
            nativeQuery = true
    )
    List<Object[]> obtenerTiposDeProductosPorEmpresa(@Param("tipo") Integer tipo);

}
