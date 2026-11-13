package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valoracion")
@Getter
@Setter
public class Valoracion extends AuditableEntity {

    @Column(name = "id_orden", nullable = false)
    private Long idOrden;

    @Column(name = "id_publicacion", nullable = false)
    private Long idPublicacion;

    @Column(name = "id_comprador", nullable = false)
    private Long idComprador;

    @Column(name = "puntuacion", nullable = false)
    private Integer puntuacion;

    @Column(name = "comentario", length = 500)
    private String comentario;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
}
