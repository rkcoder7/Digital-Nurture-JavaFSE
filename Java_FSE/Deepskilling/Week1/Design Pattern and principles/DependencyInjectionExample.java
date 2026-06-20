public class DependencyInjectionExample {

    public static void main(String[] args) {
        // The dependency is created here, outside CustomerService, and "injected" via the constructor.
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.printCustomer(1);
        service.printCustomer(2);
        service.printCustomer(99);
    }
}

/** Repository abstraction - CustomerService will depend on this interface, not a concrete class. */
interface CustomerRepository {
    String findCustomerById(long id);
}

class CustomerRepositoryImpl implements CustomerRepository {

    private final java.util.Map<Long, String> customers = new java.util.HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1L, "Mohan B");
        customers.put(2L, "Ram Kumar");
        customers.put(3L, "Alice Smith");
    }

    @Override
    public String findCustomerById(long id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}

/**
 * Service depends on the CustomerRepository abstraction. The concrete implementation is
 * supplied from outside (constructor injection), so CustomerService never creates its
 * own dependency and can be tested with any CustomerRepository implementation, including mocks.
 */
class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository; // constructor injection
    }

    public void printCustomer(long id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer #" + id + ": " + customer);
    }
}
