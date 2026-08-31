package net.providence.postgressandbox.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.providence.postgressandbox.model.Customer;
import net.providence.postgressandbox.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void customerRegister(@Valid @RequestBody Customer customer) {
        System.out.println("Customer registered: " + customer);
        customerService.saveCustomer(customer);
    }


}
