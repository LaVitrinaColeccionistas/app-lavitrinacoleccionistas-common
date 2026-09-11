package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto extends AuditableEntity {

    @Column(name = "id_vendedor", nullable = false)
    private Long idVendedor;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "estado_conservacion", length = 50)
    private String estadoConservacion;

    @Column(name = "rareza", length = 50)
    private String rareza;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio_referencia")
    private BigDecimal precioReferencia;

    @Column(name = "url_imagen", length = 500)
    private String urlImagen;

    @Column(name = "version")
    private Integer version;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetallePublicacion> detallesPublicacion = new ArrayList<>();

}
