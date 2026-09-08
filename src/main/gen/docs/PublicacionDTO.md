

# PublicacionDTO


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Long** |  |  [optional] |
|**idVendedor** | **Long** |  |  [optional] |
|**titulo** | **String** |  |  [optional] |
|**descripcion** | **String** |  |  [optional] |
|**tipoVenta** | [**TipoVentaEnum**](#TipoVentaEnum) |  |  [optional] |
|**estadoPublicacion** | [**EstadoPublicacionEnum**](#EstadoPublicacionEnum) |  |  [optional] |
|**fechaPublicacion** | **OffsetDateTime** |  |  [optional] |
|**fechaCreacion** | **OffsetDateTime** |  |  [optional] |
|**fechaActualizacion** | **OffsetDateTime** |  |  [optional] |



## Enum: TipoVentaEnum

| Name | Value |
|---- | -----|
| PRECIO_FIJO | &quot;PRECIO_FIJO&quot; |
| OFERTA_LIBRE | &quot;OFERTA_LIBRE&quot; |



## Enum: EstadoPublicacionEnum

| Name | Value |
|---- | -----|
| ACTIVA | &quot;ACTIVA&quot; |
| PAUSADA | &quot;PAUSADA&quot; |
| VENDIDA | &quot;VENDIDA&quot; |
| CANCELADA | &quot;CANCELADA&quot; |



