package com.nayanthayasiru;

import com.nayanthayasiru.model.User;
import com.nayanthayasiru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@RequestMapping("api/v1/customers")
public class Main implements CommandLineRunner {

//    private final CustomerRepository customerRepository;

//    public Main(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Ramesh");
        user.setLastName("Fadotare");
        user.setEmailId("ramesh@gmail.com");
        userRepository.save(user);

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Cena");
        user1.setEmailId("jcycsm@gmail.com");
        userRepository.save(user1);
    }

//    @GetMapping
//    public List<Customer> getCustomers(){
//        return customerRepository.findAll();
//    }
//
//    record NewCustomerRequest(String name, String email, Integer age
//    ) {};
//
//    @PostMapping
//    public void addCustomer(@RequestBody NewCustomerRequest request){
//        Customer customer = new Customer();
//        customer.setName(request.name);
//        customer.setEmail(request.email);
//        customer.setAge(request.age);
//        customerRepository.save(customer);
//    }
//    @DeleteMapping("{customerId}")
//    public void deleteCustomer(@PathVariable("customerId") Integer id){
//        customerRepository.deleteById(id);
//    }
//
//    @PutMapping("{customerId}")
//    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest editedCustomerData, HttpServletResponse res) {
//        Optional<Customer> existingCustomer = customerRepository.findById(id);
//
//        if (existingCustomer.isPresent()) { //check the customer is present
//            Customer updatedCustomer = existingCustomer.get();
//
//            //update the customer data
//            updatedCustomer.setAge(editedCustomerData.age);
//            updatedCustomer.setName(editedCustomerData.name);
//            updatedCustomer.setEmail(editedCustomerData.email);
//
//            // save updated customer
//            customerRepository.save(updatedCustomer);
//        }
//        else {
//            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
}
