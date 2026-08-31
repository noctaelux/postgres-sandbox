package net.providence.postgressandbox.service;

import net.providence.postgressandbox.dto.CustomerDTO;
import net.providence.postgressandbox.exception.ResourceFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customer) throws ResourceFoundException;

    List<CustomerDTO> retrieveCustomers();

    CustomerDTO retrieveCustomer(Long id) throws ChangeSetPersister.NotFoundException;
}
