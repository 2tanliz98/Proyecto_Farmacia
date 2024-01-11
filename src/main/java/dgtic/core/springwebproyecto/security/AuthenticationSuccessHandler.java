package dgtic.core.springwebproyecto.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, authentication);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
        // Obtiene la URL de la solicitud
        String requestUrl = request.getRequestURI();

        // Realiza el análisis de la URL para extraer la información deseada
        String[] partesUrl = requestUrl.split("/");

        // Busca la parte que contiene "carrito"
        for (String parte : partesUrl) {
            if (parte.contains("carrito")) {
                // Aquí puedes realizar alguna lógica específica si encuentras la palabra "carrito"
                return "/articulo/ver-carrito";
            }
        }
        // Si no coincide con ninguna condición, usar url predeterminada
        return "/usuario/inicio";

    }
}

