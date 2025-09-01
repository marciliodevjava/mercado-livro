package br.com.marcilio.mercado_livro.extension

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
import br.com.marcilio.mercado_livro.model.CustomerModel


fun CustomerDto.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun CustomerModel.toCustomerModel(): CustomerResponseDto {
    return CustomerResponseDto(id = this.id!!, name = this.name, email = this.email)
}
