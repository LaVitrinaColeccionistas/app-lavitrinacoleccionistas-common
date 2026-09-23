package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.TipoMovimientoIntercambio;

@Entity
@Table(name = "detalle_intercambio")
@Getter
@Setter
public class DetalleIntercambio extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_intercambio", nullable = false)
    private Intercambio intercambio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "nombre_producto_snapshot", nullable = false, length = 255)
    private String nombreProductoSnapshot;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false, length = 30)
    private TipoMovimientoIntercambio tipoMovimiento;

}