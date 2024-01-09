package dgtic.core.springwebproyecto.controller.pedido;

import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.authentication.AuthenticationService;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.pedido.PedidoService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "pedido")
@SessionAttributes("pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DireccionService direccionService;

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("detalle-orden")
    public String compraDetalle(Model model,
                                HttpServletRequest request){

        HttpSession nuevaSesion = request.getSession();
        String uniqueIdC = (String) nuevaSesion.getAttribute("identificadorTransferencia");
        Object datosTransferidos = nuevaSesion.getAttribute("datoTransferible" + uniqueIdC);
//        String uniqueIdP = (String) nuevaSesion.getAttribute("identificadorTransferencia");
//        Object pedido = nuevaSesion.getAttribute("datoTransferible_" + uniqueIdP);


        Usuario usuario = (Usuario) authenticationService.getPrincipal();
        Integer usuarioId = usuario.getId();

        Usuario us = usuarioService.buscarUsuarioId(usuarioId);
        Direccion direccion = direccionService.buscarDireccionUsuario(usuario);

        model.addAttribute("principal", authenticationService.getPrincipal());
        model.addAttribute("usuarioEntity", usuario);
        model.addAttribute("direccionEntity", direccion);
        model.addAttribute("carrito", datosTransferidos);
        //model.addAttribute("pedido", pedido);

        return "pedido/comprar";
    }
}
