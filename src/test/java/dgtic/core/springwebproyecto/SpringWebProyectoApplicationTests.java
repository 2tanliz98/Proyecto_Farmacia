package dgtic.core.springwebproyecto;

import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWebProyectoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ArticuloService articuloService;

//	@Test
//	void FiltroBusquedaTest(){
//		System.out.println(articuloService.findByNombreLikeIgnoreCase("Producto%"));
//	}

}
