package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.mapper.TransacaoMapper
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import com.github.welblade.labpicpayclonebackendapi.data.repository.transacao.TransacaoRepository
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl(
    val transacaoMapper: TransacaoMapper,
    val transacaoRepository: TransacaoRepository,
    val usuarioService: UsuarioService,
    val cartaoCreditoService: CartaoCreditoService
):TransacaoService {
    override fun processar(transacaoDto: TransacaoDto): TransacaoDto {
        val transacao = salvar(transacaoDto)
        cartaoCreditoService.salvar(transacaoDto.cartaoCredito)
        usuarioService.atualizaSaldo(transacao, transacaoDto.isCartaoCredito)
        return transacaoMapper.paraDto(transacao)
    }

    private fun salvar(transacaoDto: TransacaoDto): Transacao {
        val transacao = transacaoMapper.paraEntidade(transacaoDto)
        usuarioService.validar(transacao.destino, transacao.origem)
        return transacaoRepository.save(transacao)
    }
}