package com.github.welblade.labpicpayclonebackendapi.controller.swagger

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.erro.ErroDto
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.Authorization
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam


interface UsuarioResourceDoc {
    @ApiOperation(
        value = "Consultar contatos de um usuário por login",
        nickname = "listarContatos", notes = "",
        response = UsuarioDto::class,
        responseContainer = "object",
        authorizations = [ Authorization(value = "basicAuth") ],
        tags = ["usuarios"]
    )
    @ApiResponses(value = [
        ApiResponse(code = 200,
            message = "Contatos encontrado com sucesso",
            response = UsuarioDto::class, responseContainer =
            "object"),
        ApiResponse(code = 400,
            message = "Dados informados para a requisição estão inconsistentes",
            response = ErroDto::class, responseContainer =
            "object"),
        ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
        ApiResponse(code = 404, message = "Usuário não encontrados")
    ])
    @GetMapping("/contatos")
    fun listarContatos(@RequestParam login: String) : ResponseEntity<List<UsuarioDto>>

    @ApiOperation(
        value = "Consultar usuário por login",
        nickname = "consultarUsuarios", notes = "",
        response = UsuarioDto::class,
        responseContainer = "object",
        authorizations = [ Authorization(value = "basicAuth") ],
        tags = ["usuarios"]
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 200,
                message = "Usuário encontrado com sucesso",
                response = UsuarioDto::class,
                responseContainer = "object"),
            ApiResponse(code = 400,
                message = "Dados informados para a requisição estão inconsistentes",
                response = ErroDto::class,
                responseContainer = "object"),
            ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            ApiResponse(code = 404, message = "Usuário não encontrada")
        ]
    )
    @GetMapping("/{login}")
    fun encontrar(@PathVariable login: String) : ResponseEntity<UsuarioDto>

    @ApiOperation(value = "Consultar saldo de um usuário por login",
        nickname = "consultarSaldo",
        notes = "",
        response = UsuarioDto::class,
        responseContainer = "object",
        authorizations = [Authorization(value = "Authorization")],
        tags = ["usuarios"])
    @ApiResponses(value = [ApiResponse(code = 200,
        message = "Saldo consultado com sucesso",
        response = UsuarioDto::class,
        responseContainer = "object"), ApiResponse(code = 400,
        message = "Dados informados para a requisição estão inconsistentes",
        response = ErroDto::class,
        responseContainer = "object"), ApiResponse(code = 401,
        message = "Usuário sem permissão para acessar o recurso"), ApiResponse(code = 404,
        message = "Usuário não encontrado")])
    @GetMapping("/{login}/saldo")
    fun consultarSaldo(
        @PageableDefault(page = 0, size = 20) paginacao: Pageable,
        @PathVariable login: String,
    ): ResponseEntity<UsuarioDto>
}