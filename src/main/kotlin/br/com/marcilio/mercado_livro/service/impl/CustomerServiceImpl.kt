package br.com.marcilio.mercado_livro.service.impl

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
import br.com.marcilio.mercado_livro.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl : CustomerService {
    open lateinit var list: MutableList<CustomerResponseDto>
    var genNum: Long = 1;
    init {
        list = mutableListOf()
    }

    override fun criar(customer: CustomerDto): CustomerResponseDto {
        val dados: CustomerResponseDto = CustomerResponseDto(genNum,customer.name, customer.email)
        list.add(dados)
        number()
        return dados
    }

    override fun findById(iden: Long): CustomerResponseDto {
        val customer: CustomerResponseDto = list.first { it.id == iden } as CustomerResponseDto
        return customer
    }

    override fun findAll(): MutableList<CustomerResponseDto>{
        return list
    }

    fun number(){
        genNum++
    }
}