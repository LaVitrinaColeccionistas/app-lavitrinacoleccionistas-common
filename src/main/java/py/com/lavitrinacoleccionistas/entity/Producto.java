package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto extends AuditableEntity{

    @Column(name = "id_vendedor", nullable = false)
    private Long idVendedor;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "estado_conservacion")
    private String estadoConservacion;

    @Column(name = "rareza")
    private String rareza;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio_referencia")
    private BigDecimal precioReferencia;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "version")
    private Integer version;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "producto")
    private List<DetallePublicacion> detallesPublicacion = new ArrayList<>();
}
