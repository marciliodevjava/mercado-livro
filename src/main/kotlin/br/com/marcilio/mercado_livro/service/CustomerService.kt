package br.com.marcilio.mercado_livro.service

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto

interface CustomerService {
    fun criar(customer: CustomerDto): CustomerResponseDto
    fun findById(iden: Long): CustomerResponseDto
    fun findAll(): MutableList<CustomerResponseDto>
    fun update(id: Long, customer: br.com.marcilio.mercado_livro.dto.request.CustomerDto): br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
}