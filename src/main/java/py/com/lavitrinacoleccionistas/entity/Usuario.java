package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.EstadoUsuario;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario extends AuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoUsuario estado;

    @OneToOne(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PerfilUsuario perfil;
}
