package dgtic.core.springwebproyecto.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCryptPasswords {
    public static void main(String[] args) {
        // Crear un codificador BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Contraseña original
        String rawPassword = "hola123";

        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Imprimir la contraseña original y la versión codificada
        System.out.println("Contraseña original: " + rawPassword);
        System.out.println("Contraseña codificada: " + encodedPassword);

        // Verificar si una contraseña coincide con su versión codificada
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Coincide: " + matches);
    }
}

