package com.github.welblade.labpicpayclonebackendapi.data.dto.mapper

abstract class MappperBase<E, D> {
    abstract fun paraDto(entidade: E): D
    abstract fun paraEntidade(dto: D): E

    fun paraListaDto(entidades: List<E>): List<D> {
        return entidades.map { paraDto(it) }
    }

    fun paraListaEntidade(dtos: List<D>): List<E> {
        return dtos.map { paraEntidade(it) }
    }
}