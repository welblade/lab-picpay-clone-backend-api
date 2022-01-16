package com.github.welblade.labpicpayclonebackendapi.controller.api

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import com.github.welblade.labpicpayclonebackendapi.data.service.UsuarioService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioResource(
    private val usuarioService: UsuarioService
) : ResourceBase<UsuarioDto>() {

    @GetMapping("/{login}")
    fun encontrar(@PathVariable login: String) : ResponseEntity<UsuarioDto>{
        val usuario = usuarioService.findByLoginDto(login)
        return sucessoRetornaItem(usuario)
    }

    @GetMapping("/contatos")
    fun listarContatos(@RequestParam login: String) : ResponseEntity<List<UsuarioDto>>{
        val usuarios = usuarioService.listarContatos(login)
        return listaDeItems(usuarios)
    }

    @GetMapping("/{login}/saldo")
    fun consultarSaldo(
        @PageableDefault(page = RESOURCE_INITIAL_PAGE, size = RESOURCE_PAGE_SIZE)
        paginacao: Pageable,
        @PathVariable
        login: String
    ): ResponseEntity<UsuarioDto> {
        val usuario = usuarioService.findByLoginDto(login)
        return sucessoRetornaItem(usuario)
    }
}