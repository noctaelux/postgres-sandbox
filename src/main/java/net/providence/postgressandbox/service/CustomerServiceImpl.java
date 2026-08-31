package net.providence.postgressandbox.service;

import lombok.RequiredArgsConstructor;
import net.providence.postgressandbox.model.Customer;
import net.providence.postgressandbox.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
