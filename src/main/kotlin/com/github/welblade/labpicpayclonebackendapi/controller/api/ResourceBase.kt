package com.github.welblade.labpicpayclonebackendapi.controller.api

import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder

const val RESOURCE_PAGE_SIZE = 20
const val RESOURCE_INITIAL_PAGE = 0

abstract class ResourceBase<T> {
    fun itemCriado(item: T): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.CREATED).body(item)
    }

    fun itemCriadoComURI(item: T, uriBuilder: UriComponentsBuilder, path: String, codigo: String): ResponseEntity<T> {
        val uri = uriBuilder.path(path).buildAndExpand(codigo).toUri()
        return ResponseEntity.created(uri).body(item)
    }

    fun itemNaoEncontrado(): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

    fun sucesso(): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    fun sucessoRetornaItem(item: T): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.OK).body(item)
    }

    fun listaVazia(): ResponseEntity<List<T>> {
        return ResponseEntity.status(HttpStatus.OK).body(listOf<T>())
    }

    fun listaDeItems(items: List<T>): ResponseEntity<List<T>> {
        return ResponseEntity.status(HttpStatus.OK).body(items)
    }

    fun listaDeItemsPaginada(itens: Page<T>): ResponseEntity<Page<T>> {
        return ResponseEntity.status(HttpStatus.OK).body<Page<T>>(itens)
    }

    fun requisicaoMalSucedida(): ResponseEntity<T> {
        return ResponseEntity.badRequest().build()
    }
}