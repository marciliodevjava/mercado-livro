package br.com.marcilio.mercado_livro.controller

import br.com.marcilio.mercado_livro.dto.request.CustomerDto
import br.com.marcilio.mercado_livro.dto.response.CustomerResponseDto
import br.com.marcilio.mercado_livro.service.CustomerService
import br.com.marcilio.mercado_livro.utils.BuildResponse
import br.com.marcilio.mercado_livro.utils.DefaultResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book-market")
open class CustomerController(
    private val build: BuildResponse<Any>,
    private val service: CustomerService
) {

    @GetMapping("/{id}")
    open fun getCustomer(@PathVariable id: Long): ResponseEntity<DefaultResponse<CustomerResponseDto>> {
        val custumer: CustomerResponseDto = service.findById(id)
        val response: DefaultResponse<CustomerResponseDto> = build.buildResponse(
            data = custumer,
            message = "Solicitação realizada con sucesso!",
            status = HttpStatus.OK.value()
        )
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping
    open fun getCustomerAll(@RequestParam name: String?): ResponseEntity<DefaultResponse<List<CustomerResponseDto>>> {
        val list = service.findAll(name)
        val response: DefaultResponse<List<CustomerResponseDto>> = build.buildResponse(
            data = list,
            message = "Solicitação realizada con sucesso!",
            status = HttpStatus.OK.value()
        )
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }


    @PostMapping
    open fun create(@RequestBody customer: CustomerDto): ResponseEntity<DefaultResponse<CustomerResponseDto>> {
        val data: CustomerResponseDto = service.criar(customer)
        val response: DefaultResponse<CustomerResponseDto> = build.buildResponse(
            data = data,
            message = "Criado com sucesso!",
            status = HttpStatus.CREATED.value()
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PatchMapping("/{id}")
    open fun update(
        @PathVariable id: Long,
        @RequestBody customer: CustomerDto
    ): ResponseEntity<DefaultResponse<CustomerResponseDto>> {
        var data: CustomerResponseDto = service.update(id, customer)
        val response: DefaultResponse<CustomerResponseDto> = build.buildResponse(
            data = data,
            message = "Customer updated with success.", status = HttpStatus.NO_CONTENT.value()
        )
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response)
    }

    @DeleteMapping("/{id}")
    open fun delete(@PathVariable id: Long): ResponseEntity<DefaultResponse<String>> {
        var message: String = service.delete(id)
        val response: DefaultResponse<String> = build.buildResponse(data = message,
            message = message,
            status = HttpStatus.OK.value())
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }


}