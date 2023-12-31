package dgtic.core.springwebproyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "articulo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="articulo_tipo", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Articulo {
    @TableGenerator(name="Prod_Gen",
            table="id_gen",
            pkColumnName="gen_name",
            valueColumnName="gen_val",
            initialValue = 100,
            pkColumnValue = "prod_gen",
            allocationSize = 1)
    @Id
    @Column(name = "id_articulo")
    //@GeneratedValue(strategy = Generat ionType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Prod_Gen")
    private Integer articuloId;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name="marca")
    private String marca;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "unidades")
    private Integer unidades;

    @Column(precision = 8, scale = 2)
    private BigDecimal precio;

    public Articulo (){}
    public Articulo( String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "articuloId=" + articuloId +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                '}';
    }
}
