package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoIntercambio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "intercambio")
@Getter
@Setter
public class Intercambio extends AuditableEntity {

    @Column(name = "id_usuario_proponente", nullable = false)
    private Long idUsuarioProponente;

    @Column(name = "id_usuario_receptor", nullable = false)
    private Long idUsuarioReceptor;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 30)
    private EstadoIntercambio estado;

    @Column(name = "diferencia_dinero")
    private BigDecimal diferenciaDinero;

    @Column(name = "usuario_paga_diferencia")
    private Long usuarioPagaDiferencia;

    @OneToMany(
            mappedBy = "intercambio",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<DetalleIntercambio> detalles = new ArrayList<>();

}
