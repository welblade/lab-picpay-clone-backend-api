package com.github.welblade.labpicpayclonebackendapi.controller.api

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.service.TransacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

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
        return itemCriadoComURI(retorno, uriBuilder, "/transacoes", retorno.codigo)
    }
}