package com.github.welblade.labpicpayclonebackendapi.data.dto.mapper

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import org.modelmapper.ModelMapper
import org.modelmapper.PropertyMap
import org.springframework.stereotype.Component

@Component
class TransacaoMapper(
    val userMapper: UsuarioMapper
): MapperBase<Transacao, TransacaoDto>() {
    override fun paraDto(entidade: Transacao): TransacaoDto {
        val modelMapper = ModelMapper()
        modelMapper.addMappings(object: PropertyMap<Transacao, TransacaoDto>() {
            override fun configure() {}
        })
        return modelMapper.map(entidade, TransacaoDto::class.java)
    }

    override fun paraEntidade(dto: TransacaoDto): Transacao {
        return Transacao(
            codigo = dto.codigo,
            origem = userMapper.paraEntidade(dto.origem),
            destino = userMapper.paraEntidade(dto.destino),
            dataHora = dto.dataHora,
            valor = dto.valor
        )
    }
}