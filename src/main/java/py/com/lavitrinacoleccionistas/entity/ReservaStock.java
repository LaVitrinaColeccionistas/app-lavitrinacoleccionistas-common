package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoReserva;
import py.com.lavitrinacoleccionistas.enums.TipoOrigenReserva;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva_stock",
        uniqueConstraints = @UniqueConstraint(name = "uk_reserva_stock_origen_item",
                columnNames = {"tipo_origen", "id_origen", "id_producto", "id_detalle_publicacion"}))
@Getter
@Setter
public class ReservaStock extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_origen", nullable = false, length = 20)
    private TipoOrigenReserva tipoOrigen;

    @Column(name = "id_origen", nullable = false)
    private Long idOrigen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_publicacion")
    private DetallePublicacion detallePublicacion;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "id_usuario_destino")
    private Long idUsuarioDestino;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_reserva", nullable = false, length = 30)
    private EstadoReserva estadoReserva;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDateTime fechaExpiracion;

    @Transient
    public Long getIdOrden() {
        return tipoOrigen == TipoOrigenReserva.ORDEN ? idOrigen : null;
    }
}