package com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito.CartaoCreditoDto
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import java.io.Serializable
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class TransacaoDto(
    @NotNull
    val codigo: String,
    @NotNull
    val origem: UsuarioDto,
    @NotNull
    val destino: UsuarioDto,
    @NotNull
    val dataHora: LocalDateTime,
    @NotNull
    val valor: Double,
    val cartaoCredito: CartaoCreditoDto,
    val isCartaoCredito: Boolean = false,
) : Serializable
