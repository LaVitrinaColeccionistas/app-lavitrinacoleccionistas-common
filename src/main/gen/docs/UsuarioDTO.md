

# UsuarioDTO


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Long** |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**nombre** | **String** |  |  [optional] |
|**apellido** | **String** |  |  [optional] |
|**telefono** | **String** |  |  [optional] |
|**direccionEnvio** | **String** |  |  [optional] |
|**estado** | [**EstadoEnum**](#EstadoEnum) |  |  [optional] |
|**rol** | [**RolDTO**](RolDTO.md) |  |  [optional] |
|**fechaCreacion** | **OffsetDateTime** |  |  [optional] |
|**fechaActualizacion** | **OffsetDateTime** |  |  [optional] |



## Enum: EstadoEnum

| Name | Value |
|---- | -----|
| ACTIVO | &quot;ACTIVO&quot; |
| SUSPENDIDO | &quot;SUSPENDIDO&quot; |
| PENDIENTE_VERIFICACION | &quot;PENDIENTE_VERIFICACION&quot; |
| RECHAZADO | &quot;RECHAZADO&quot; |



