# La Vitrina Coleccionistas

## Documentación OpenAPI Generator
- La estructura de PostgreSQL es gestionada mediante **Liquibase**.
-   https://www.baeldung.com/java-openapi-generator-server

## Modelo de datos
Las entidades comparten atributos mediante `BaseEntity` y `AuditableEntity`, aplicando
herencia, abstracción y encapsulación.

### Usuarios, roles y soporte

``` mermaid
erDiagram
    ROL {
        BIGINT id PK
        VARCHAR tipo_rol
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }

    USUARIO {
        BIGINT id PK
        BIGINT id_rol FK
        VARCHAR email
        VARCHAR password_hash
        VARCHAR estado
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }

    PERFIL_USUARIO {
        BIGINT id PK
        BIGINT id_usuario FK
        VARCHAR nombre
        VARCHAR apellido
        VARCHAR telefono
        VARCHAR direccion_envio
    }

    TICKET_SOPORTE {
        BIGINT id PK
        VARCHAR nombre
        VARCHAR email
        VARCHAR asunto
        TEXT mensaje
        TIMESTAMP fecha_envio
    }

    ROL ||--o{ USUARIO : asignado_a
    USUARIO ||--|| PERFIL_USUARIO : tiene
```

`Usuario` concentra los datos de acceso, estado y rol, mientras que
`PerfilUsuario` almacena la información personal. `TicketSoporte`
representa el formulario de contacto definido para soporte.

### MS1 - Catálogo

``` mermaid
erDiagram
    PRODUCTO {
        BIGINT id PK
        BIGINT id_vendedor
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
        BIGINT id PK
        BIGINT id_vendedor
        VARCHAR titulo
        TEXT descripcion
        VARCHAR tipo_venta
        VARCHAR estado
        TIMESTAMP fecha_publicacion
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }

    DETALLE_PUBLICACION {
        BIGINT id PK
        BIGINT id_publicacion FK
        BIGINT id_producto FK
        DECIMAL precio_unitario
        INT cantidad_publicada
    }

    OFERTA {
        BIGINT id PK
        BIGINT id_publicacion FK
        BIGINT id_comprador
        DECIMAL monto_ofertado
        VARCHAR estado
        TIMESTAMP fecha_oferta
        TIMESTAMP fecha_respuesta
    }

    PUBLICACION ||--o{ DETALLE_PUBLICACION : contiene
    PRODUCTO ||--o{ DETALLE_PUBLICACION : referenciado_en
    PUBLICACION ||--o{ OFERTA : recibe
```

El catálogo permite representar productos, publicaciones y ofertas.
`DetallePublicacion` resuelve la relación entre publicaciones y
productos.

### MS2 - Órdenes / Compras

``` mermaid
erDiagram
    ORDEN_COMPRA {
        BIGINT id PK
        BIGINT id_comprador
        TIMESTAMP fecha_orden
        VARCHAR estado_orden
        DECIMAL monto_subtotal
        DECIMAL costo_envio
        DECIMAL monto_total
        VARCHAR metodo_pago
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }

    DETALLE_ORDEN_COMPRA {
        BIGINT id PK
        BIGINT id_orden FK
        BIGINT id_producto
        BIGINT id_publicacion
        VARCHAR nombre_producto_snapshot
        INT cantidad
        DECIMAL precio_unitario_historico
        DECIMAL subtotal_item
    }

    ORDEN_COMPRA ||--o{ DETALLE_ORDEN_COMPRA : contiene
```

La orden persiste la compra y sus ítems. El pago se mantiene como un
proceso externo al sistema, de acuerdo con el diseño funcional del
proyecto.

### MS3 - Intercambios

``` mermaid
erDiagram
    INTERCAMBIO {
        BIGINT id PK
        BIGINT id_usuario_proponente
        BIGINT id_usuario_receptor
        VARCHAR estado
        DECIMAL diferencia_dinero
        BIGINT usuario_paga_diferencia
        TIMESTAMP fecha_creacion
        TIMESTAMP fecha_actualizacion
    }

    DETALLE_INTERCAMBIO {
        BIGINT id PK
        BIGINT id_intercambio FK
        BIGINT id_producto
        VARCHAR nombre_producto_snapshot
        INT cantidad
        VARCHAR tipo_movimiento
    }

    INTERCAMBIO ||--o{ DETALLE_INTERCAMBIO : contiene
```

Los intercambios registran al proponente, receptor, productos
involucrados y una posible diferencia de dinero. 

