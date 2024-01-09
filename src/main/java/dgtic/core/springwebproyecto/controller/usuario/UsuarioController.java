package dgtic.core.springwebproyecto.controller.usuario;

import dgtic.core.springwebproyecto.converter.MayusculasConverter;
import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.authentication.AuthenticationService;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.pedido.PedidoService;
import dgtic.core.springwebproyecto.service.tarjeta.TarjetaService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import dgtic.core.springwebproyecto.util.RenderPagina;
import dgtic.core.springwebproyecto.validation.UsuarioValidacion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "usuario")
@SessionAttributes("usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioValidacion usuarioValidacion;
    @Autowired
    TarjetaService tarjetaService;
    @Autowired
    DireccionService direccionService;
    @Autowired
    PedidoService pedidoService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("alta-usuario")
    public String paginaRegistro(Model model) {
        Usuario usuarioEntity = new Usuario();
        model.addAttribute("operacion", "Registro Usuario");
        model.addAttribute("usuarioEntity", usuarioEntity);
        return "usuario/alta-usuario";
    }

    @PostMapping("registro-usuario")
    public String entradaRegistro(@Valid @ModelAttribute("usuarioEntity") Usuario usuarioEntity,
                                  BindingResult result, Model model, RedirectAttributes flash) {
        usuarioValidacion.validate(usuarioEntity, result);
        if (result.hasErrors()) {
            for (FieldError e :result.getFieldErrors()) {
                System.out.println(e.getDefaultMessage());
                System.out.println(e.getCode());
            }
            return "usuario/alta-usuario";
        }
        try {
            usuarioService.altaUsuario(usuarioEntity);
            Integer usuarioId = usuarioEntity.getId();
            flash.addFlashAttribute("success", "Se almaceno con éxito");
            flash.addFlashAttribute("usuarioId", usuarioId);
            return "redirect:/usuario/inicio";
        } catch(Exception ex){
            ObjectError er=new ObjectError("Duplicados","El correo ya existe");
            model.addAttribute("warning","Correo repetido");
            result.addError(er);
        }
        return "usuario/alta-usuario";
    }

    @InitBinder("usuarioEntity")
    public void evaluar(WebDataBinder binder) {
        binder.addValidators(usuarioValidacion);
        binder.registerCustomEditor(String.class,
                "nombre", new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "apPaterno", new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "apMaterno", new MayusculasConverter());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("menu-usuario")
    public String paginaMenu(Model model,
                             RedirectAttributes flash,
                             Authentication authentication,
                             @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("principal", authenticationService.getPrincipal());

        Usuario usuario = (Usuario) authentication.getPrincipal();
        Integer usuarioId = usuario.getId();

        model.addAttribute("usuarioId", usuarioId);
        Usuario usuarioEntity = usuarioService.buscarUsuarioId(usuarioId);
        try{
            Direccion direccionEntity = direccionService.buscarDireccionUsuario(usuarioEntity);
            model.addAttribute("direccionEntity", direccionEntity);
        }catch (Exception ex) {
            ObjectError er = new ObjectError("Error", ex.getMessage());
            model.addAttribute("warning", "Agrege su información domicilial");
            model.addAttribute("warning", ex.getMessage());
        }

        Pageable pagReq = PageRequest.of(page, 3);
        Page<Pedido> pedidos = pedidoService.findPedidoByUsuario(pagReq, usuario);
        RenderPagina<Pedido> render = new RenderPagina<>("lista-pedidos",pedidos);
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("page", render);
        model.addAttribute("operacion", "Inicio de sesión");
        model.addAttribute("usuarioEntity", usuarioEntity);
        return "usuario/menu-usuario";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("eliminar-usuario")
    public String eliminarUsuario(RedirectAttributes flash,
                                  Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Integer usuarioId = usuario.getId();

        Usuario us = usuarioService.buscarUsuarioId(usuarioId);
        Direccion dir = direccionService.buscarDireccionUsuario(us);
        Tarjeta tar = tarjetaService.buscarTarjetaUsuario(us);
        if(dir != null){
            direccionService.borrar(dir.getId());
        }
        if(tar != null){
            tarjetaService.borrar(tar.getId());
        }
        usuarioService.borrar(usuarioId);
        flash.addFlashAttribute("success", "El usuario se borro correctamente");
        return "redirect:/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("modificar-usuario")
    public String modificarUsuario(Model model,
                                   Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Integer usuarioId = usuario.getId();

        Usuario us = usuarioService.buscarUsuarioId(usuarioId);
        model.addAttribute("usuarioEntity", us);
        return "usuario/alta-usuario";
    }

    @GetMapping("/login")
    public String loginUsuario(Model model){
        Usuario usuarioEntity = new Usuario();
        model.addAttribute("usuarioEntity", usuarioEntity);
        return "usuario/login";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/inicio")
    public String paginaInicio(Model model){
        return "usuario/inicio";
    }

//    @GetMapping("/final")
//    public String paginaFinal(){
//        return "/";
//    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("cerrar-sesion")
    public String cierreSesion(HttpServletRequest request, HttpServletResponse response) {
        // autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // Cierre de sesión
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "usuario/final";
    }


}
