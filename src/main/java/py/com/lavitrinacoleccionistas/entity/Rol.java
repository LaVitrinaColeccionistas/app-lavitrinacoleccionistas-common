package py.com.lavitrinacoleccionistas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import py.com.lavitrinacoleccionistas.enums.TipoRol;

@Entity
@Table(name = "rol")
@Getter
@Setter
public class Rol extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private TipoRol tipoRol;

}
