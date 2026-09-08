package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_orden")
@Getter
@Setter
public class DetalleOrdenCompra extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenCompra ordenCompra;

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(name = "id_publicacion", nullable = false)
    private Long idPublicacion;

    @Column(name = "nombre_producto_snapshot", nullable = false)
    private String nombreProductoSnapshot;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario_historico", nullable = false)
    private BigDecimal precioUnitarioHistorico;

    @Column(name = "subtotal_item", nullable = false)
    private BigDecimal subtotalItem;
}