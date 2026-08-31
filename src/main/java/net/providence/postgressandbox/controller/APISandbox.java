package net.providence.postgressandbox.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.providence.postgressandbox.dto.CustomerDTO;
import net.providence.postgressandbox.exception.ResourceFoundException;
import net.providence.postgressandbox.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class APISandbox {

    private final CustomerService customerService;

    @RequestMapping("/v1/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/v1/customer/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void customerRegister(@Valid @RequestBody CustomerDTO customer) throws ResourceFoundException {
        customerService.saveCustomer(customer);
    }

    @GetMapping("/v1/customer/list")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> customerList(){
        return customerService.retrieveCustomers();
    }

    @GetMapping("/v1/customer/{id}")
    public CustomerDTO customerDetail(@PathVariable Long id) throws NoSuchElementException {
        return customerService.retrieveCustomer(id);
    }


}
