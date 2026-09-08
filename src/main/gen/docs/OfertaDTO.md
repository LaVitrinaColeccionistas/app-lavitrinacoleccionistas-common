

# OfertaDTO


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Long** |  |  [optional] |
|**idPublicacion** | **Long** |  |  [optional] |
|**idComprador** | **Long** |  |  [optional] |
|**estadoOferta** | [**EstadoOfertaEnum**](#EstadoOfertaEnum) |  |  [optional] |
|**fechaOferta** | **OffsetDateTime** |  |  [optional] |
|**fechaRespuesta** | **OffsetDateTime** |  |  [optional] |



## Enum: EstadoOfertaEnum

| Name | Value |
|---- | -----|
| PENDIENTE | &quot;PENDIENTE&quot; |
| ACEPTADA | &quot;ACEPTADA&quot; |
| RECHAZADA | &quot;RECHAZADA&quot; |
| EXPIRADA | &quot;EXPIRADA&quot; |



