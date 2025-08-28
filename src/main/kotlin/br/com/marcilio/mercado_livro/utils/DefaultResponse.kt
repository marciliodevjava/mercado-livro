package br.com.marcilio.mercado_livro.utils

class DefaultResponse <T>(
    var data: T,
    val message: String,
    val status: Int
){
}