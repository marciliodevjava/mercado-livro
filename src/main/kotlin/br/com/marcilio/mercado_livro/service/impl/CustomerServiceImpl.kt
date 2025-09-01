package br.com.marcilio.mercado_livro.service.impl

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
import br.com.marcilio.mercado_livro.extension.toCustomerModel
import br.com.marcilio.mercado_livro.model.CustomerModel
import br.com.marcilio.mercado_livro.repository.CustomerRepository
import br.com.marcilio.mercado_livro.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    open lateinit var list: MutableList<CustomerResponseDto>

    init {
        list = mutableListOf()
    }

    override fun criar(customer: CustomerDto): CustomerResponseDto {
        var customer: CustomerModel = customer.toCustomerModel()
        customer = customerRepository.save(customer)
        return customer.toCustomerModel()
    }

    override fun findById(iden: Long): CustomerResponseDto {
        var customer: CustomerModel =
            customerRepository.findById(iden).orElseThrow { RuntimeException("Não existe esse dado") }
        return customer.toCustomerModel()
    }

    override fun findAll(): MutableList<CustomerResponseDto> {
        var list: MutableList<CustomerModel> = customerRepository.findAll()
        return list.map { it ->
            CustomerResponseDto(
                id = it.id!!,
                name = it.name,
                email = it.email
            )
        }.toMutableList()
    }

    override fun update(id: Long, customer: CustomerDto): CustomerResponseDto {
        var customerModel: CustomerModel =
            customerRepository.findById(id).orElseThrow { RuntimeException("Customer not found") }
        customerModel.name = customer.name
        customerModel.email = customer.email
        customerRepository.save(customerModel)
        return customerModel.toCustomerModel()
    }

    override fun delete(id: Any): String {
        val iden: Long = (id as Number).toLong()
        customerRepository.deleteById(iden)
        return "Item removed successfully!"
    }

}