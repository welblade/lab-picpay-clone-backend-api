package com.github.welblade.labpicpayclonebackendapi.data.dto.model.erro

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class ErroDto(
    val campo: String,
    val mensagem: String
)
