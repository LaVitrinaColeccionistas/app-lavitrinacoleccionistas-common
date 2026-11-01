package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoReserva;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva_stock")
@Getter
@Setter
public class ReservaStock extends AuditableEntity {

    @Column(name = "id_orden", nullable = false)
    private Long idOrden;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_detalle_publicacion", nullable = false)
    private DetallePublicacion detallePublicacion;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_reserva", nullable = false, length = 30)
    private EstadoReserva estadoReserva;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDateTime fechaExpiracion;

}