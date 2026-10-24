package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoReclamo;
import py.com.lavitrinacoleccionistas.enums.TipoReclamo;

@Entity
@Table(name = "reclamo")
@Getter
@Setter
public class Reclamo extends AuditableEntity {

    @Column(name = "id_orden", nullable = false)
    private Long idOrden;

    @Column(name = "id_comprador", nullable = false)
    private Long idComprador;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_reclamo", nullable = false, length = 30)
    private TipoReclamo tipoReclamo;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 30)
    private EstadoReclamo estado;

    @Column(name = "respuesta", length = 1000)
    private String respuesta;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
}
