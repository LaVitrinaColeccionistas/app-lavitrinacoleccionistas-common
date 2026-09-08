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

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(name = "nombre_producto_snapshot", nullable = false)
    private String nombreProductoSnapshot;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false)
    private TipoMovimientoIntercambio tipoMovimiento;
}

