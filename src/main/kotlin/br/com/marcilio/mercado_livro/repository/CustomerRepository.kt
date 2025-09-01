package br.com.marcilio.mercado_livro.repository

import br.com.marcilio.mercado_livro.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<CustomerModel, Long>{
}