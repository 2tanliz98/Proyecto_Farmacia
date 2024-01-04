package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nombre;

    @Column(name = "ap_pat")
    private String apPaterno;

    @Column(name = "ap_mat")
    private String apMaterno;

    @Column(length = 50)
    @Email
    private String email;

    @Column(name = "contrasenia")
    private String password;

    private Integer rol = 1;

//    @OneToOne
//    @JoinColumn(name = "direccion")
//    private Direccion direccion;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER )
    private List<Tarjeta> tarjeta;
    @Column(length = 20)
    private String alias;
    @NotBlank(message = "Teléfono no debe estar vacío")
    @Size(min=10,max=10,message = "Teléfono debe ser de 10 dígitos")
    @Pattern(regexp = "55[0-9]{8,8}", message = "Teléfono debe empezar con 55 y tener 10 dígitos")
    private String telefono;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apPaterno + '\'' +
                ", apellidoMaterno='" + apMaterno + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
//                ", direccion=" + direccion +
                //", tarjeta=" + tarjeta +
                ", alias='" + alias + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}