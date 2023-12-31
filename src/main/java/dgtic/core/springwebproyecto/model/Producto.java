package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "producto")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="producto_tipo", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Producto {
    @TableGenerator(name="Prod_Gen",
            table="id_gen",
            pkColumnName="gen_name",
            valueColumnName="gen_val",
            initialValue = 100,
            pkColumnValue = "prod_gen",
            allocationSize = 1)
    @Id
    @Column(name = "id_producto")
    //@GeneratedValue(strategy = Generat ionType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Prod_Gen")
    private Integer productoId;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name="marca")
    private String marca;
    @Column(name = "imagen")
    private String imagen;

    public Producto (){}
    public Producto( String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "producto_id=" + productoId +
                "\n nombre='" + nombre + '\'' +
                "\n marca='" + marca + '\'' +
                "\n imagen='" + imagen + '\'' +
                '}';
    }
}
