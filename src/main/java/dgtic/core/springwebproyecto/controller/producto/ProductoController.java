package dgtic.core.springwebproyecto.controller.producto;

import dgtic.core.springwebproyecto.model.*;
import dgtic.core.springwebproyecto.service.cosmetico.CosmeticoService;
import dgtic.core.springwebproyecto.service.empresaProductoService.EmpresaProductoService;
import dgtic.core.springwebproyecto.service.medicamento.MedicamentoService;
import dgtic.core.springwebproyecto.service.producto.ProductoService;
import jakarta.validation.Valid;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "producto")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    CosmeticoService cosmeticoService;

    @Autowired
    MedicamentoService medicamentoService;

    @Autowired
    EmpresaProductoService empresaProductoService;

    @Autowired
    ProductoService productoService;

    // Almacena los artículos del carrito de compras en una lista de carritos
    // El pedido se vacía cuando sale de sesión
    // El pedido se guarda cuando se realiza la compra
    List<CarritoCompra> carritoSesion = new ArrayList<>();
    Pedido pedido = new Pedido();

    @GetMapping("/producto-home/{productoId}")
    public String productoHome(@PathVariable("productoId") Integer id, Model model){

        EmpresaProducto empresaProducto;
        Producto articulo = productoService.findbyId(id).get();
        model.addAttribute("producto", articulo);
        empresaProducto = empresaProductoService.findByProducto(articulo);
        model.addAttribute("empresaProducto", empresaProducto);
        return "producto/producto-home";
    }


    @PostMapping("/add-carrito")
    public String addProducto(@RequestParam Integer id, @RequestParam Integer cantidad,
                               Model model) {

        Producto articulo = productoService.findbyId(id).get();
        EmpresaProducto ep = empresaProductoService.findByProducto(articulo);
        CarritoCompra carrito = new CarritoCompra();
        CarritoCompraId carritoId = new CarritoCompraId();
        carritoId.setPedido(pedido);


        double sumaTotal = 0;

        carritoId.setProducto(articulo);

        carrito.setCantidad(cantidad);
        carrito.setCarritoCompraId(carritoId);

        carritoSesion.add(carrito);

        BigDecimal multiplicador = new BigDecimal(cantidad);
        pedido.setTotal(ep.getPrecio().multiply(multiplicador));


//        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
//
//        orden.setTotal(sumaTotal);
        model.addAttribute("carrito", carrito);
//        model.addAttribute("orden", orden);
//

        return "/usuario/carrito";
    }
}
