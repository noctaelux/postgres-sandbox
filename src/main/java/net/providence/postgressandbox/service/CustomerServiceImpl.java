package net.providence.postgressandbox.service;

import lombok.RequiredArgsConstructor;
import net.providence.postgressandbox.dto.CustomerDTO;
import net.providence.postgressandbox.exception.ResourceFoundException;
import net.providence.postgressandbox.model.Customer;
import net.providence.postgressandbox.repository.CustomerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerDTO customerDto) throws ResourceFoundException {

        Customer customer = mapCustomer(customerDto);

        Optional<Customer> customerOptional = customerRepository.findByEmail(customer.getEmail());

        if(customerOptional.isPresent()){
            throw new ResourceFoundException("El correo ya existe");
        }



        customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> retrieveCustomers() {
        return customerRepository.findAll().stream().map(this::mapCustomerDTO).toList();
    }

    @Override
    public CustomerDTO retrieveCustomer(Long id) throws ChangeSetPersister.NotFoundException {
        return customerRepository.findById(id)
                .map(this::mapCustomerDTO)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    private Customer mapCustomer(CustomerDTO customerDTO){
        return Customer.builder()
                .name(customerDTO.getName())
                .surname(customerDTO.getSurname())
                .email(customerDTO.getEmail())
                .build();
    }

    private CustomerDTO mapCustomerDTO(Customer customer){
        return CustomerDTO.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .build();
    }
}
