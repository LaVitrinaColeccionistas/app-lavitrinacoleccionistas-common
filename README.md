Documentacion openapi generator
- https://www.baeldung.com/java-openapi-generator-server 

## Modelado de base de datos

### Servicio de Identidad

```mermaid
erDiagram
    USUARIO {
        UUID id_usuario PK
        VARCHAR email
        VARCHAR nombre
        VARCHAR apellido
        VARCHAR telefono
        VARCHAR direccion_envio
        VARCHAR estado
        TIMESTAMP fecha_registro
        TIMESTAMP fecha_actualizacion
    }
    ROL {
        SMALLINT id_rol PK
        VARCHAR nombre
    }
    USUARIO_ROL {
        UUID id_usuario FK
        SMALLINT id_rol FK
        TIMESTAMP fecha_asignacion
    }
    TICKET_SOPORTE {
        UUID id_ticket PK
        VARCHAR nombre
        VARCHAR email
        VARCHAR asunto
        TEXT mensaje
        TIMESTAMP fecha_envio
    }
    USUARIO ||--o{ USUARIO_ROL : tiene
    ROL ||--o{ USUARIO_ROL : asignado_en
```

### MS1 - Catálogo

```mermaid
erDiagram
    PRODUCTO {
        UUID id_producto PK
        UUID id_vendedor "ref externa a USUARIO"
        VARCHAR nombre
        VARCHAR categoria
        VARCHAR estado_conservacion
        VARCHAR rareza
        INT stock
        DECIMAL precio_referencia
        VARCHAR url_imagen
        INT version
        BOOLEAN activo
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }
    PUBLICACION {
        UUID id_publicacion PK
        UUID id_vendedor "ref externa a USUARIO"
        VARCHAR titulo
        TEXT descripcion
        VARCHAR tipo_venta
        VARCHAR estado
        TIMESTAMP fecha_publicacion
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }
    DETALLE_PUBLICACION {
        UUID id_detalle_pub PK
        UUID id_publicacion FK
        UUID id_producto FK
        DECIMAL precio_unitario
        INT cantidad_publicada
    }
    PUBLICACION ||--o{ DETALLE_PUBLICACION : contiene
    PRODUCTO ||--o{ DETALLE_PUBLICACION : referenciado_en
```

### MS2 - Órdenes / Compras

```mermaid
erDiagram
    ORDEN_COMPRA {
        UUID id_orden PK
        UUID id_comprador "ref externa a USUARIO"
        TIMESTAMP fecha_orden
        VARCHAR estado_orden
        DECIMAL monto_subtotal
        DECIMAL costo_envio
        DECIMAL comision_plataforma
        DECIMAL monto_total
        VARCHAR metodo_pago
        TIMESTAMP fecha_actualizacion
    }
    DETALLE_ORDEN {
        UUID id_detalle_orden PK
        UUID id_orden FK
        UUID id_producto "ref externa a PRODUCTO (MS1)"
        UUID id_publicacion "ref externa a PUBLICACION (MS1)"
        VARCHAR nombre_producto_snapshot
        INT cantidad
        DECIMAL precio_unitario_historico
        DECIMAL subtotal_item
    }
    ORDEN_COMPRA ||--o{ DETALLE_ORDEN : contiene
```

### MS3 - Intercambios

```mermaid
erDiagram
    INTERCAMBIO {
        UUID id_intercambio PK
        UUID id_usuario_proponente "ref externa a USUARIO"
        UUID id_usuario_receptor "ref externa a USUARIO"
        VARCHAR estado
        DECIMAL diferencia_dinero
        UUID usuario_paga_diferencia "ref externa a USUARIO"
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }
    DETALLE_INTERCAMBIO {
        UUID id_detalle PK
        UUID id_intercambio FK
        UUID id_producto "ref externa a PRODUCTO (MS1)"
        VARCHAR nombre_producto_snapshot
        INT cantidad
        VARCHAR tipo_movimiento
    }
    INTERCAMBIO ||--o{ DETALLE_INTERCAMBIO : contiene
```
