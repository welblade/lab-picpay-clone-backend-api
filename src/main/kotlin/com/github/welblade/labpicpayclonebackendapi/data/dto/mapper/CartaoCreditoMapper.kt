package com.github.welblade.labpicpayclonebackendapi.data.dto.mapper

import com.github.welblade.labpicpayclonebackendapi.core.util.CartaoCreditoUtility
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito.CartaoCreditoDto
import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.CartaoCredito
import com.github.welblade.labpicpayclonebackendapi.data.service.UsuarioService
import org.modelmapper.ModelMapper
import org.modelmapper.PropertyMap
import org.springframework.stereotype.Component

@Component
class CartaoCreditoMapper (
    private val usuarioService: UsuarioService
        ): MapperBase<CartaoCredito, CartaoCreditoDto>() {
    override fun paraDto(entidade: CartaoCredito): CartaoCreditoDto {
        val modelMapper = ModelMapper()
        modelMapper.addMappings(object: PropertyMap<CartaoCredito, CartaoCreditoDto>() {
            override fun configure() {}
        })
        return modelMapper.map(entidade, CartaoCreditoDto::class.java)
    }

    override fun paraEntidade(dto: CartaoCreditoDto): CartaoCredito {
        return CartaoCredito(
            numero = CartaoCreditoUtility.mask(dto.numero),
            bandeira = dto.bandeira,
            email = dto.email,
            numeroToken = dto.numeroToken,
            usuario = usuarioService.findByLogin(dto.usuario.login)
        )
    }
}