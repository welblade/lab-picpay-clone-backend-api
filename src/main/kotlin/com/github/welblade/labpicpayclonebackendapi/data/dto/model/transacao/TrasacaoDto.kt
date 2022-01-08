package com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import java.io.Serializable
import java.time.LocalDateTime

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class TrasacaoDto(
    val id: Long? = null,
    val codigo: String? = null,
    val origem: UsuarioDto? = null,
    val destino: UsuarioDto? = null,
    val dataHora: LocalDateTime? = null,
    val valor: Double? = null,
) : Serializable
