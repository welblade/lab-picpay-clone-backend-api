package com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito

enum class BandeiraCartao(val descricao: String) {
    VISA("Visa"),
    MASTERCARD("Master Card"),
    ELO("Elo"),
    NULL("");
}
