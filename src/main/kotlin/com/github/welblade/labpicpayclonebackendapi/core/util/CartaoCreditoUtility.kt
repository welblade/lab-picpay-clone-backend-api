package com.github.welblade.labpicpayclonebackendapi.core.util

class CartaoCreditoUtility {
    companion object {
        fun mask(numeroCartao: String) : String {
            return numeroCartao.replace("\\b(\\d{4})(\\d{8})(\\d{4})".toRegex(), "$1XXXXXXXX$3")
        }
    }
}