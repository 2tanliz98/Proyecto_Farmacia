package dgtic.core.springwebproyecto;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import dgtic.core.springwebproyecto.service.detalleCompra.DetalleCompraService;
import dgtic.core.springwebproyecto.service.pedido.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringWebProyectoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ArticuloService articuloService;
	@Autowired
	DetalleCompraService detalleCompraService;
	@Autowired
	PedidoService pedidoService;

//	@Test
//	void FiltroBusquedaTest(){
//		System.out.println(articuloService.findByNombreLikeIgnoreCase("Producto%"));
//	}

	@Test
	void findDetallePedido(){
		Pedido pedido =  pedidoService.buscarPedidoId(19);
		List<DetalleCompra> detalleCompra =
				detalleCompraService.findDetalleCompraByDetalleCompraId_Pedido(pedido);
		System.out.println(detalleCompra);
		for(DetalleCompra detalle: detalleCompra){
			System.out.println(detalle.toString());
			System.out.println(detalle.getDetalleCompraId().getArticulo().getNombre());
		}

	}

}
