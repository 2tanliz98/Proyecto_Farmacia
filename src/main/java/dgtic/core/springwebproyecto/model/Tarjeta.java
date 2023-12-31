package dgtic.core.springwebproyecto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @Column(name="id_tarjeta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    @Column(name="numero_tarjeta")
    @NotBlank(message = "El número de tarjeta no debe estar vacío")
    @Pattern(regexp = "[0-9]{10}",message = "Tarjeta no valida")
    private String numeroTarjeta;

    @Column(name="tipo_tarjeta")
    private String tipoTarjeta;

    @Column(name="fecha_expiracion")
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = "yyyy-MM-dd")
    private Date date;

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                "\n usuario=" + usuario.toString() +
                "\n numeroTarjeta='" + numeroTarjeta + '\'' +
                "\n tipo=" + tipoTarjeta +
                "\n date=" + date +
                '}';
    }
}
