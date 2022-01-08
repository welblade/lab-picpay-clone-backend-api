package com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.CartaoCredito
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.OneToMany
import kotlin.random.Random

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UsuarioDto (
        val login: String,
        val senha: String,
        val email: String,
        val nomeCompleto: String,
        val cpf: String,
        val dataNascimento: LocalDateTime,
        val saldo: Double,
        val ativo: Boolean,
        @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE], orphanRemoval = true)
        val cartoesCredito: List<CartaoCredito> = listOf(),
        ){
        constructor(): this("", "", "", "", "", LocalDateTime.now(), 0.0, false)
}