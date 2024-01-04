package dgtic.core.springwebproyecto.controller.articulo;

import dgtic.core.springwebproyecto.model.*;
import dgtic.core.springwebproyecto.service.cosmetico.CosmeticoService;
import dgtic.core.springwebproyecto.service.medicamento.MedicamentoService;
import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "articulo")
@SessionAttributes("articulo")
public class ArticuloController {

    @Autowired
    CosmeticoService cosmeticoService;

    @Autowired
    MedicamentoService medicamentoService;

    @Autowired
    ArticuloService articuloService;

    @Value("${imagen.ruta}")
    private String archivoRuta;

    // Almacena los artículos del carrito de compras en una lista de carritos
    // El pedido se vacía cuando sale de sesión
    // El pedido se guarda cuando se realiza la compra
    List<DetalleCompra> detalleSesion = new ArrayList<>();
    Pedido pedido = new Pedido();

    @GetMapping("/articulo-home/{articuloId}")
    public String articuloHome(@PathVariable("articuloId") Integer id, Model model){

        Articulo articulo = articuloService.findbyId(id).get();
        model.addAttribute("articulo", articulo);
        return "articulo/articulo-home";
    }

    //Agregar elementos al carrito de compras
    @PostMapping("/add-carrito")
    public String addArticulo(@RequestParam Integer articuloId, @RequestParam Integer cantidad,
                               Model model) {
        // verificación de existencia del artículo
        Articulo articulo = articuloService.findbyId(articuloId).get();

        // creación de un nuevo id de detalle de orden
        DetalleCompraId ordenId = new DetalleCompraId();
        ordenId.setPedido(pedido);
        ordenId.setArticulo(articulo);

        //cración de nuevo detalle de orden
        DetalleCompra orden = new DetalleCompra();
        orden.setDetalleCompraId(ordenId);
        orden.setCantidad(cantidad);
        BigDecimal subTotal = new BigDecimal(cantidad);
        subTotal = subTotal.multiply(articulo.getPrecio());
        orden.setPrecioTotal(subTotal);

        //validar que le producto no se añada 2 veces
        Integer idArt = articulo.getArticuloId();
        boolean ingresado = detalleSesion.stream().
                anyMatch(p -> p.getDetalleCompraId().getArticulo().getArticuloId()==idArt);

        List<DetalleCompra> ordenUpdate = new ArrayList<DetalleCompra>();
        if (!ingresado) {
            detalleSesion.add(orden);
        }else{
            for (DetalleCompra detalleOrden : detalleSesion) {
                if (!Objects.equals(detalleOrden.getDetalleCompraId().getArticulo().getArticuloId(), idArt)) {
                    ordenUpdate.add(detalleOrden);
                }
            }
            detalleSesion = ordenUpdate;
            detalleSesion.add(orden);
        }

        BigDecimal sumaTotal = detalleSesion.stream()
                .map(DetalleCompra::getPrecioTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        orden.setPrecioTotal(sumaTotal);
        pedido.setTotal(sumaTotal);
        pedido.setFecha(new Date());
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);

        return "articulo/carrito";
    }

    // inicio sesion
    @GetMapping("ver-carrito")
    public  String verCarrito(Model model){
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);
        return "articulo/carrito";
    }

    // quitar un producto del carrito
    @GetMapping("delete-carrito/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model) {

        // lista nueva de prodcutos
        List<DetalleCompra> ordenesNuevo = new ArrayList<DetalleCompra>();

        for (DetalleCompra detalleOrden : detalleSesion) {
            if (!Objects.equals(detalleOrden.getDetalleCompraId().getArticulo().getArticuloId(), id)) {
                ordenesNuevo.add(detalleOrden);
            }
        }

        // poner la nueva lista con los productos restantes
        detalleSesion = ordenesNuevo;

        // nueva suma de total
        pedido.setTotal(new BigDecimal(0));
        BigDecimal sumaTotal = detalleSesion.stream()
                .map(DetalleCompra::getPrecioTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setTotal(sumaTotal);
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);

        return "redirect:/articulo/ver-carrito";
    }

    @GetMapping("modificar-carrito/{id}")
    public String modificarCarrito(@PathVariable("id") Integer id,Model model){

        return "articulo/articulo-home/"+id;
    }

}
