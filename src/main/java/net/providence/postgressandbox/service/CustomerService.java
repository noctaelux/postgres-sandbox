package net.providence.postgressandbox.service;

import net.providence.postgressandbox.dto.CustomerDTO;
import net.providence.postgressandbox.exception.ResourceFoundException;

import java.util.List;
import java.util.NoSuchElementException;

public interface CustomerService {

    void saveCustomer(CustomerDTO customer) throws ResourceFoundException;

    List<CustomerDTO> retrieveCustomers();

    CustomerDTO retrieveCustomer(Long id) throws NoSuchElementException;
}
