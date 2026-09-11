package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoPublicacion;
import py.com.lavitrinacoleccionistas.enums.TipoVenta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publicacion")
@Getter
@Setter
public class Publicacion extends AuditableEntity {

    @Column(name = "id_vendedor", nullable = false)
    private Long idVendedor;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_venta", nullable = false, length = 30)
    private TipoVenta tipoVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_publicacion", nullable = false, length = 30)
    private EstadoPublicacion estadoPublicacion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetallePublicacion> detallePublicacion = new ArrayList<>();

    @OneToMany(mappedBy = "publicacion", fetch = FetchType.LAZY)
    private List<Oferta> ofertas = new ArrayList<>();

}
