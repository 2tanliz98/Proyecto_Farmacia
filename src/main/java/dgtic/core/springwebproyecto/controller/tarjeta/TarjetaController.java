package dgtic.core.springwebproyecto.controller.tarjeta;

import dgtic.core.springwebproyecto.model.Tarjeta;
import dgtic.core.springwebproyecto.model.TipoTarjeta;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.service.tarjeta.TarjetaService;
import dgtic.core.springwebproyecto.service.usuario.UsuarioService;
import dgtic.core.springwebproyecto.validation.TarjetaValidacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "tarjeta")
@SessionAttributes("tarjeta")
public class TarjetaController {
    @Autowired
    TarjetaService tarjetaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TarjetaValidacion tarjetaValidacion;

    @GetMapping("alta-tarjeta")
    public String paginaRegistro(Model model,
                                 Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();

        Tarjeta tarjetaEntity=new Tarjeta();
        tarjetaEntity.setUsuario(usuario);
        model.addAttribute("operacion","Registro Tarjeta");
        model.addAttribute("tarjetaEntity",tarjetaEntity);
        model.addAttribute("tiposTarjeta", TipoTarjeta.values());
        return "tarjeta/alta-tarjeta";
    }

    @PostMapping("registro-tarjeta")
    public String entradaRegistro(@Valid @ModelAttribute("tarjetaEntity") Tarjeta tarjetaEntity,
                                  BindingResult result, Model model, RedirectAttributes flash){
        tarjetaValidacion.validate(tarjetaEntity,result);
        model.addAttribute("tiposTarjeta", TipoTarjeta.values());
        if(result.hasErrors()){
            for (FieldError e :result.getFieldErrors()) {
            }            return "tarjeta/alta-tarjeta";
        }
        try {
            tarjetaService.guardar(tarjetaEntity);
            flash.addFlashAttribute("success","Se almaceno con éxito");
            Integer usuarioId = tarjetaEntity.getUsuario().getId();
            flash.addFlashAttribute("usuarioId",usuarioId);
            model.addAttribute("tarjetaEntity", tarjetaEntity);
            return "redirect:/usuario/menu-usuario";
        }catch(Exception ex){
            ObjectError er=new ObjectError("Duplicados","Número de tarjeta ya existe");
            model.addAttribute("warning","Número de tarjeta repetido");
            result.addError(er);
        }
        return "tarjeta/alta-tarjeta";
    }

    @GetMapping("borrar-tarjeta/{id}")
    public String borrarrTarjeta(@PathVariable("id") Integer id,Model model,
                                  RedirectAttributes flash){
        Tarjeta tarjetaDel = tarjetaService.buscarTarjetaId(id);
        Integer usuarioId = tarjetaDel.getUsuario().getId();
        flash.addAttribute("usuarioId", usuarioId);
        tarjetaService.borrar(id);
        flash.addFlashAttribute("success","La tarjeta se borro correctamente");
        return "redirect:/usuario/menu-usuario";
    }

    @GetMapping("modificar-tarjeta/{id}")
    public String modificarTarjeta(@PathVariable("id") Integer id,Model model){
        model.addAttribute("tiposTarjeta", TipoTarjeta.values());
        Tarjeta tarjeta= tarjetaService.buscarTarjetaId(id);
        model.addAttribute("tarjetaEntity",tarjeta);
        return "tarjeta/alta-tarjeta";
    }

    @InitBinder("tarjetaEntity")
    public void evaluar(WebDataBinder binder) {
        binder.addValidators(tarjetaValidacion);
    }

}

