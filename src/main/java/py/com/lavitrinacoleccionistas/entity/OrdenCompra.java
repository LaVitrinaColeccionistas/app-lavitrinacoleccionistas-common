package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoOrden;
import py.com.lavitrinacoleccionistas.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orden_compra")
@Getter
@Setter
public class OrdenCompra extends AuditableEntity {

    @Column(name = "id_comprador", nullable = false)
    private Long idComprador;

    @Column(name = "fecha_orden", nullable = false)
    private LocalDateTime fechaOrden;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_orden", nullable = false)
    private EstadoOrden estadoOrden;

    @Column(name = "monto_subtotal", nullable = false)
    private BigDecimal montoSubtotal;

    @Column(name = "costo_envio", nullable = false)
    private BigDecimal costoEnvio;

    @Column(name = "monto_total", nullable = false)
    private BigDecimal montoTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @OneToMany(
            mappedBy = "ordenCompra",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetalleOrdenCompra> detalles = new ArrayList<>();
}