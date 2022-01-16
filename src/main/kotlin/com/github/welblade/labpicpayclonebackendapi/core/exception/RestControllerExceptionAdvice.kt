package com.github.welblade.labpicpayclonebackendapi.core.exception

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.erro.ErroDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerExceptionAdvice(
    @Autowired
    val messageSource: MessageSource
){
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handler(exception: MethodArgumentNotValidException): List<ErroDto> {
        val dto = mutableListOf<ErroDto>()
        val fieldErrors = exception.bindingResult.fieldErrors
        fieldErrors.forEach {
            val mensagem = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            dto.add(ErroDto(it.field, mensagem))
        }
        return dto.toList()
    }
}
