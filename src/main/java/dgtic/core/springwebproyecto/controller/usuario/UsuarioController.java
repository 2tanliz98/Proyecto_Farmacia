package dgtic.core.springwebproyecto.controller.usuario;

import dgtic.core.springwebproyecto.converter.MayusculasConverter;
import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.tarjeta.TarjetaService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import dgtic.core.springwebproyecto.validation.UsuarioValidacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
            usuarioService.guardar(usuarioEntity);
            Integer usuarioId = usuarioEntity.getId();
            flash.addFlashAttribute("success", "Se almaceno con éxito");
            flash.addFlashAttribute("usuarioId", usuarioId);
            return "redirect:/usuario/menu-usuario/"+usuarioId;
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

    @GetMapping("menu-usuario/{usuarioId}")
    public String paginaMenu(@PathVariable("usuarioId") Integer id, Model model,
                              RedirectAttributes flash) {
        model.addAttribute("usuarioId", id);
        Usuario usuarioEntity = usuarioService.buscarUsuarioId(id);
        try{
            Direccion direccionEntity = direccionService.buscarDireccionUsuario(usuarioEntity);
            model.addAttribute("direccionEntity", direccionEntity);
        }catch (Exception ex){
            ObjectError er = new ObjectError("Error", ex.getMessage());
            model.addAttribute("warning", "Agrege su información domicilial");
            model.addAttribute("warning", ex.getMessage());
        }
        finally {
            model.addAttribute("operacion", "Inicio de sesión");
            model.addAttribute("usuarioEntity", usuarioEntity);
            return "usuario/menu-usuario";
        }
    }

    @GetMapping("eliminar-usuario/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id, Model model,
                                  RedirectAttributes flash) {
        Usuario us = usuarioService.buscarUsuarioId(id);
        Direccion dir = direccionService.buscarDireccionUsuario(us);
        Tarjeta tar = tarjetaService.buscarTarjetaUsuario(us);
        if(dir != null){
            direccionService.borrar(dir.getId());
        }
        if(tar != null){
            tarjetaService.borrar(tar.getId());
        }
        usuarioService.borrar(id);
        flash.addFlashAttribute("success", "El usuario se borro correctamente");
        return "redirect:/";
    }

    @GetMapping("modificar-usuario/{id}")
    public String modificarUsuario(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioId(id);
        model.addAttribute("usuarioEntity", usuario);
        return "usuario/alta-usuario";
    }

    @GetMapping("login-usuario")
    public String loginUsuario(Model model){
        Usuario usuarioEntity = new Usuario();
        model.addAttribute("operacion", "Registro Usuario");
        model.addAttribute("usuarioEntity", usuarioEntity);
        return "usuario/login";
    }



}
