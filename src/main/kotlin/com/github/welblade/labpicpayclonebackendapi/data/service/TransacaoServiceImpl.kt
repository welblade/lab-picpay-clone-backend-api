package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.mapper.TransacaoMapper
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import com.github.welblade.labpicpayclonebackendapi.data.repository.transacao.TransacaoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl(
    val transacaoMapper: TransacaoMapper,
    val transacaoRepository: TransacaoRepository,
    val usuarioService: UsuarioService,
    val cartaoCreditoService: CartaoCreditoService
):TransacaoService {
    override fun processar(transacaoDto: TransacaoDto): TransacaoDto {
        val transacaoSalva = salvar(transacaoDto)
        cartaoCreditoService.salvar(transacaoDto.cartaoCredito)
        usuarioService.atualizaSaldo(transacaoSalva, transacaoDto.isCartaoCredito)
        return transacaoMapper.paraDto(transacaoSalva)
    }

    override fun listar(paginacao: Pageable, login: String) : Page<TransacaoDto> {
        val transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao)
        return transacaoMapper.paraPageDto(transacoes)
    }

    private fun salvar(transacaoDto: TransacaoDto): Transacao {
        val transacao = transacaoMapper.paraEntidade(transacaoDto)
        usuarioService.validar(transacao.destino, transacao.origem)
        return transacaoRepository.save(transacao)
    }
}