package com.github.welblade.labpicpayclonebackendapi.data.dto.mapper

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import org.modelmapper.ModelMapper
import org.modelmapper.PropertyMap
import org.springframework.stereotype.Component

@Component
class UsuarioMapper:MapperBase<Usuario, UsuarioDto>() {
    override fun paraDto(entidade: Usuario): UsuarioDto {
        val modelMapper = ModelMapper()
        modelMapper.addMappings(object: PropertyMap<Usuario, UsuarioDto>() {
            override fun configure() {}
        })
        return modelMapper.map(entidade, UsuarioDto::class.java)
    }

    override fun paraEntidade(dto: UsuarioDto): Usuario {
        val modelMapper = ModelMapper()
        modelMapper.addMappings(object: PropertyMap<UsuarioDto, Usuario>() {
            override fun configure() {}
        })
        return modelMapper.map(dto, Usuario::class.java)
    }
}