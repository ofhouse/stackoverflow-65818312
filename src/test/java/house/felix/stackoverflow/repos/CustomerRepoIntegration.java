package house.felix.stackoverflow.repos;

import house.felix.stackoverflow.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepoIntegration {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    @Transactional
    void findById() {
        Customer customer = customerRepo.saveAndFlush(new Customer());

        List<Customer> allCustomers = customerRepo.findAll();
        assertEquals(1, allCustomers.size());

        Optional<Customer> foundCustomer = customerRepo.findById(customer.getId());
        assertTrue(foundCustomer.isPresent());
    }
}