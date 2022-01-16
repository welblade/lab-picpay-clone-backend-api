package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.mapper.CartaoCreditoMapper
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito.CartaoCreditoDto
import com.github.welblade.labpicpayclonebackendapi.data.repository.cartaocredito.CartaoCreditoRepository
import org.springframework.stereotype.Service

@Service
class CartaoCreditoServiceImpl(
    private val cartaoCreditoRepository: CartaoCreditoRepository,
    private val cartaoCreditoMapper: CartaoCreditoMapper,
    private val usuarioService: UsuarioService
): CartaoCreditoService {
    override fun salvar(cartaoCreditoDto: CartaoCreditoDto): CartaoCreditoDto {
        var resultCartao:CartaoCreditoDto? = null
        if (cartaoCreditoDto.isSalvar) {
            val cartaoCredito = cartaoCreditoMapper.paraEntidade(cartaoCreditoDto)
            usuarioService.validar(cartaoCredito.usuario)
            val cartao = cartaoCreditoRepository.save(cartaoCredito)
            resultCartao = cartaoCreditoMapper.paraDto(cartao)
        }
        return resultCartao!!
    }
}