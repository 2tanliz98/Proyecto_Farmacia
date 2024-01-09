package dgtic.core.springwebproyecto.controller.articulo;

import dgtic.core.springwebproyecto.model.*;
import dgtic.core.springwebproyecto.service.authentication.AuthenticationService;
import dgtic.core.springwebproyecto.service.cosmetico.CosmeticoService;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.medicamento.MedicamentoService;
import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import dgtic.core.springwebproyecto.service.metodoPago.MetodoPagoService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DireccionService direccionService;

    @Autowired
    MetodoPagoService metodoPagoService;

    @Autowired
    private AuthenticationService authenticationService;


    // Almacena los artículos del carrito de compras en una lista de carritos
    // El pedido se vacía cuando sale de sesión
    // El pedido se guarda cuando se realiza la compra
    List<DetalleCompra> detalleSesion = new ArrayList<>();
    Pedido pedido = new Pedido();

    @GetMapping("/articulo-home/{articuloId}")
    public String articuloHome(@PathVariable("articuloId") Integer id, Model model){
        Articulo articulo = articuloService.findbyId(id).get();
        model.addAttribute("articulo", articulo);
        model.addAttribute("principal", authenticationService.getPrincipal());
        return "articulo/articulo-home";
    }

    //Agregar elementos al carrito de compras
    @PostMapping("/add-carrito")
    public String addArticulo(@RequestParam Integer articuloId,
                              @RequestParam Integer cantidad,
                               Model model) {
        model.addAttribute("principal", authenticationService.getPrincipal());

        // verificación de existencia del artículo
        Articulo articulo = articuloService.findbyId(articuloId).get();

        // creación de un nuevo id de detalle de orden
        DetalleCompraId ordenId = new DetalleCompraId();
        ordenId.setPedido(pedido);
        ordenId.setArticulo(articulo);

        // cración de nuevo detalle de orden
        DetalleCompra orden = new DetalleCompra();
        orden.setDetalleCompraId(ordenId);
        orden.setCantidad(cantidad);

        // precio de artículo y subtotales
        BigDecimal subTotal = new BigDecimal(cantidad);
        subTotal = subTotal.multiply(articulo.getPrecio());
        orden.setPrecioTotal(subTotal);

        // validar que le producto no se añada 2 veces
        Integer idArt = articulo.getArticuloId();
        boolean ingresado = detalleSesion.stream().
                anyMatch(p -> p.getDetalleCompraId().getArticulo().getArticuloId()==idArt);

        // permite editar la lista de artículos dentro del carrito
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

        // obtiene suma del total (total pedido)
        BigDecimal sumaTotal = detalleSesion.stream()
                .map(DetalleCompra::getPrecioTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setTotal(sumaTotal);
        pedido.setFecha(new Date());
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);

        return "articulo/carrito";
    }

    // inicio sesion
    @PreAuthorize("isAuthenticated()")
    @GetMapping("ver-carrito")
    public  String verCarrito(Model model){
        model.addAttribute("principal", authenticationService.getPrincipal());
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);
        return "articulo/carrito";
    }

    // quitar un producto del carrito
    @GetMapping("delete-carrito/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model) {
        model.addAttribute("principal", authenticationService.getPrincipal());
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

    @GetMapping("detalle-orden")
    public String comprar(Model model,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//        session.setAttribute("datoTransferible", detalleSesion);
//        String uniqueIdC = UUID.randomUUID().toString();
//        session.setAttribute("identificadorTransferenciaC", uniqueIdC);
//
//        session.setAttribute("pedido", pedido);
//        String uniqueIdP = UUID.randomUUID().toString();
//        session.setAttribute("identificadorTransferenciaP", uniqueIdP);

//        response.sendRedirect("/pedido/detalle-orden");
//        return "/pedido/comprar";

        Usuario usuario = (Usuario) authenticationService.getPrincipal();
        Integer usuarioId = usuario.getId();

        Usuario us = usuarioService.buscarUsuarioId(usuarioId);
        Direccion direccion = direccionService.buscarDireccionUsuario(usuario);

        model.addAttribute("principal", authenticationService.getPrincipal());
        model.addAttribute("usuarioEntity", usuario);
        model.addAttribute("direccionEntity", direccion);
        model.addAttribute("carrito", detalleSesion);
        model.addAttribute("pedido", pedido);
        model.addAttribute("metodoPago", metodoPagoService.findAll());
        return "pedido/comprar";
    }

    @PreAuthorize("isAuthenticated() ")
    @PostMapping("guardar-orden")
    public String confirmarOrden(Model model){

        return "redirec:/";
    }
}
