package dgtic.core.springwebproyecto.security;

import dgtic.core.springwebproyecto.model.CustomAuthenticationException;
import dgtic.core.springwebproyecto.model.Usuario;
import dgtic.core.springwebproyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import java.util.Optional;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    AuthenticationExceptionHandler authenticationExceptionHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return email -> {
            Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
            if (usuario.isPresent()) {
                return usuario.get();
            }
            throw new UsernameNotFoundException(
                    "Usuario: " + email + " no encontrado");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
            .authorizeRequests()
            .requestMatchers("/usuario/menu-usuario",
                    "/usuario/eliminar-usuario/",
                    "/usuario/modificar-usuario/",
                    "/articulo/guardar-orden",
                    "/articulo/detalle-orden",
                    "usuario/inicio",
                    "/tarjeta/**").hasRole("CLIENTE")
            .requestMatchers("/", "/**",
                    "/articulo/ver-carrito",
                    "/articulo/add-carrito",
                    "/articulo/articulo-home/**",
                    "/articulo/modificar-carrito/**",
                    "/articulo/delete-carrito/**",
                    "/usuario/alta-usuario",
                    "/usuario/registro-usuario",
                    "/direccion/**",
                    "/resources/**").permitAll().anyRequest().permitAll()
            .and()
            .formLogin(formLogin ->
                formLogin
                        .loginPage("/usuario/login").permitAll()
                        .loginProcessingUrl("/autenticacion")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .failureHandler(authenticationExceptionHandler)
            );
        return http.build();
    }

}
