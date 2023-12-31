package dgtic.core.springwebproyecto.controller.direccion;

import dgtic.core.springwebproyecto.converter.MayusculasConverter;
import dgtic.core.springwebproyecto.model.Direccion;
import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.direccion.DireccionService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import dgtic.core.springwebproyecto.validation.DireccionValidacion;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "direccion")
@SessionAttributes("direccion")
public class DireccionController {

    @Autowired
    DireccionService direccionService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    DireccionValidacion direccionValidacion;

    @GetMapping("alta-direccion/{usuarioId}")
    public String paginaRegistro(@PathVariable("usuarioId") Integer usuarioId,
                                 Model model, RedirectAttributes flash){
        Direccion direccionEntity=new Direccion();
        Usuario usuarioEntity = usuarioService.buscarUsuarioId(usuarioId);
        direccionEntity.setUsuario(usuarioEntity);
        model.addAttribute("operacion","Registro Direccion");
        model.addAttribute("direccionEntity",direccionEntity);
        model.addAttribute("usuarioId",usuarioId);
        return "direccion/alta-direccion";
    }


    @PostMapping("registro-direccion")
    public String entradaRegistro(@Valid @ModelAttribute("direccionEntity") Direccion direccionEntity,
                                  BindingResult result, Model model, RedirectAttributes flash){
        //direccionValidacion.validate(direccionEntity,result);
        if (result.hasErrors()) {
            for (FieldError e :result.getFieldErrors()) {
                System.out.println(e.getDefaultMessage());
                System.out.println(e.getCode());
            }
            return "direccion/alta-direccion";
        }
        try {
            direccionService.guardar(direccionEntity);
            flash.addFlashAttribute("success","Se almaceno con éxito ");
            flash.addFlashAttribute("usuarioId",direccionEntity.getUsuario().getId());
            model.addAttribute("usuarioId",direccionEntity.getUsuario().getId());
            return "redirect:/usuario/menu-usuario/"+direccionEntity.getUsuario().getId();
        }catch (Exception ex){
            ObjectError er = new ObjectError("Error",
                    "Ha ocurrido un error al registrar dirección");
            model.addAttribute("warning",ex.getMessage());
            result.addError(er);
        }
        return "direccion/alta-direccion";
    }

    @InitBinder("direccionEntity")
    public void evaluar(WebDataBinder binder) {
        binder.addValidators(direccionValidacion);

        binder.registerCustomEditor(String.class,
                "calle", new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "colonia", new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "municipio", new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "estado", new MayusculasConverter());
    }

    @GetMapping("modificar-direccion/{id}")
    public String modificarUsuario(@PathVariable("id") Integer id,Model model){
        Direccion direccion= direccionService.buscarDireccionId(id);
        model.addAttribute("direccionEntity",direccion);
        return "direccion/alta-direccion";
    }

    @GetMapping("borrar-direccion/{id}")
    public String borrarrDireccion(@PathVariable("id") Integer id,Model model,
                                 RedirectAttributes flash){
        Direccion direccionDel = direccionService.buscarDireccionId(id);
        Integer usuarioId = direccionDel.getUsuario().getId();
        flash.addAttribute("usuarioId", usuarioId);
        direccionService.borrar(id);
        flash.addFlashAttribute("success","La dirección se borró correctamente");
        return "redirect:/usuario/menu-usuario/"+usuarioId;
    }



}
