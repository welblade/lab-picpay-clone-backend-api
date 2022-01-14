package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl:TransacaoService {
    override fun processar(transacaoDto: TransacaoDto): TransacaoDto {
        val transacao = salvar(transacaoDto)
        cartaoCeditoService.salvar(transacaoDto.cartaoCredito)
        usuarioService.atualizaSaldo(transacao, transacaoDto.isCartaoCredito)
        return transacaoConversor.convertEntidadeParaDto(transacao)
    }

    private fun salvar(transacaoDto: TransacaoDto): Transacao {
        val transacao = transacaoConversor.converterDtoParaEntidade(transacaoDto)
        usuarioService.validar(transacao.destino, transacao.origem)
        transacaoRepository.save()
    }
}