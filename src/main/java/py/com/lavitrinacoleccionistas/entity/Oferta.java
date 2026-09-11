package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoOferta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "oferta")
@Getter
@Setter
public class Oferta extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publicacion", nullable = false)
    private Publicacion publicacion;

    @Column(name = "id_comprador", nullable = false)
    private Long idComprador;

    @Column(name = "monto_ofertado", nullable = false)
    private BigDecimal montoOfertado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_oferta", nullable = false, length = 30)
    private EstadoOferta estadoOferta;

    @Column(name = "fecha_oferta", nullable = false)
    private LocalDateTime fechaOferta;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

}
