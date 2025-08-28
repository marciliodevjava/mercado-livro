package br.com.marcilio.mercado_livro.utils

import org.springframework.stereotype.Component

@Component
class BuildResponse<T> {

    fun <T>buildResponse(data:T, message:String, status: Int): DefaultResponse<T>{
        return DefaultResponse(data,message,status)
    }
}