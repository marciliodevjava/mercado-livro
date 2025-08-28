package br.com.marcilio.mercado_livro.service.impl

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
import br.com.marcilio.mercado_livro.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl : CustomerService {
    open lateinit var list: MutableList<CustomerResponseDto>

    init {
        list = mutableListOf()
    }

    override fun criar(customer: CustomerDto): CustomerResponseDto {
        val dados: CustomerResponseDto = CustomerResponseDto(customer.id, customer.name, customer.email)
        list.add(dados)
        return dados
    }

    override fun findById(iden: Long): CustomerResponseDto {
        val customer: CustomerResponseDto = list.first { it.id == iden } as CustomerResponseDto
        return customer
    }
}