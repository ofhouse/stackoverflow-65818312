package house.felix.stackoverflow.repos;

import house.felix.stackoverflow.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepo extends JpaRepository<Customer, UUID> {}
