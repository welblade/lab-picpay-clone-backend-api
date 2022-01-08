package com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UsuarioDto (
        @NotNull
        val login: String,
        val senha: String,
        val email: String,
        val nomeCompleto: String,
        val cpf: String,
        val dataNascimento: LocalDateTime,
        val saldo: Double,
        val telefone: String,
        )