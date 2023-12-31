package dgtic.core.springwebproyecto.controller;

import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InicioController {
    @Value("${spring.application.name}")
    String nombreApp;

    @Value("${imagen.ruta}")
    private String archivoRuta;

    @Autowired
    ArticuloService articuloService;

    @GetMapping("/")
    public String inicioPagina(Model model)  {
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("nombreAplicacion",nombreApp);
        model.addAttribute("fecha",formateadorFecha.format(new Date()));
        model.addAttribute("contenido", "Bienvenido");
        model.addAttribute("archivo", archivoRuta);
        model.addAttribute("articulos", articuloService.findAll());
        return "principal";
    }

}
