package dgtic.core.springwebproyecto.controller;

import dgtic.core.springwebproyecto.model.Articulo;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.service.articulo.ArticuloService;
import dgtic.core.springwebproyecto.service.authentication.AuthenticationService;
import dgtic.core.springwebproyecto.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InicioController {
    @Value("${spring.application.name}")
    String nombreApp;

    @Value("${imagen.ruta}")
    private String archivoRuta;

    @Autowired
    ArticuloService articuloService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/")
    public String inicioPagina(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page)  {
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("nombreAplicacion",nombreApp);
        model.addAttribute("fecha",formateadorFecha.format(new Date()));
        model.addAttribute("contenido", "Bienvenido");
        model.addAttribute("archivo", archivoRuta);
        model.addAttribute("principal", authenticationService.getPrincipal());
        Pageable pagReq = PageRequest.of(page, 9);
        Page<Articulo> articulos = articuloService.findAll(pagReq);
        RenderPagina<Articulo> render = new RenderPagina<>("/",articulos);
        model.addAttribute("articulos", articulos);
        model.addAttribute("page", render);

        return "principal";
    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam String query, Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page) {
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("nombreAplicacion",nombreApp);
        model.addAttribute("fecha",formateadorFecha.format(new Date()));
        model.addAttribute("contenido", "Bienvenido");
        model.addAttribute("archivo", archivoRuta);
        model.addAttribute("principal", authenticationService.getPrincipal());
        Pageable pagReq = PageRequest.of(page, 9);
        query = "%"+query+"%";
        Page<Articulo> articulos = articuloService.findByNombreLikeIgnoreCase(query,pagReq);
        model.addAttribute("articulos", articulos);
        RenderPagina<Articulo> render = new RenderPagina<>("/",articulos);
        model.addAttribute("page", render);

        return "principal";
    }

}
