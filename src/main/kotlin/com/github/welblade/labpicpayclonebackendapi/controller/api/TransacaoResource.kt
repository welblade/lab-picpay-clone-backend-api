package com.github.welblade.labpicpayclonebackendapi.controller.api

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.service.TransacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

const val DEFAULT_PAGE = 0
const val DEFAULT_PAGE_SIZE = 20

@RestController
@RequestMapping("/transacoes")
class TransacaoResource(
    val transacaoService: TransacaoService
    ) : ResourceBase<TransacaoDto>() {

    @PostMapping        
    fun salvar(
        @RequestBody @Valid transacaoDto: TransacaoDto,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<TransacaoDto> {
        val retorno: TransacaoDto = transacaoService.processar(transacaoDto)
        return itemCriadoComURI(retorno, uriBuilder, "/transacoes/{codigo}", retorno.codigo)
    }

    @GetMapping
    fun listar(
        @PageableDefault(page = DEFAULT_PAGE, size = DEFAULT_PAGE_SIZE)
        paginacao: Pageable,
        @RequestParam
        login: String
    ): ResponseEntity<Page<TransacaoDto>> {
        val transacoes: Page<TransacaoDto> = transacaoService.listar(paginacao, login)
        return listaDeItemsPaginada(transacoes)
    }
}