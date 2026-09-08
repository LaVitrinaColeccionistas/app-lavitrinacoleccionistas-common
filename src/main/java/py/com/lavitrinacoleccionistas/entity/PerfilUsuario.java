package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil_usuario")
@Getter
@Setter
public class PerfilUsuario extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String telefono;

    @Column(name = "direccion_envio")
    private String direccionEnvio;
}