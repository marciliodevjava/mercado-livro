package br.com.marcilio.mercado_livro.model

data class CustomerModel(
    var id: Long? = null,
    var name: String,
    var email: String
)