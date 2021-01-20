package house.felix.stackoverflow.repos;

import house.felix.stackoverflow.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepoIntegration {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    @Transactional
    void findById() {
        UUID uuid = UUID.randomUUID();
        Customer customer = new Customer(uuid);
        customerRepo.save(customer);

        List<Customer> allCustomers = customerRepo.findAll();
        assertEquals(1, allCustomers.size());

        Optional<Customer> foundCustomer = customerRepo.findById(uuid);
        assertTrue(foundCustomer.isPresent());
    }
}