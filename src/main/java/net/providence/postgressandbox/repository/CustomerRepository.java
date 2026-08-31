package net.providence.postgressandbox.repository;

import net.providence.postgressandbox.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
