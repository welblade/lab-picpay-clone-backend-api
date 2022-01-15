package com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.BandeiraCartao
import java.io.Serializable
import javax.validation.constraints.NotNull

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class CartaoCreditoDto(
    val numero: String,
    val bandeira: BandeiraCartao,
    val codigoSeguranca: String,
    val dataExpiracao: String,
    val nomeTitular: String,
    val email: String,
    val numeroToken: String,
    @NotNull
    val usuario: UsuarioDto,
    var isSalvar: Boolean = false
) : Serializable
