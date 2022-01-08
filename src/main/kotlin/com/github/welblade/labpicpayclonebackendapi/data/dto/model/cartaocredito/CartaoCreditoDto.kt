package com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.BandeiraCartao
import java.io.Serializable
import javax.validation.constraints.NotNull

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class CartaoCreditoDto(
    val id: Long? = null,
    val numero: String? = null,
    val bandeira: BandeiraCartao? = null,
    val codigoSeguranca: String,
    val dataExpiracao: String,
    val nomeTitular: String,
    val email: String? = null,
    val numeroToken: String? = null,
    @NotNull
    val usuario: UsuarioDto = UsuarioDto(),
    var isSalvo: Boolean = false
) : Serializable
