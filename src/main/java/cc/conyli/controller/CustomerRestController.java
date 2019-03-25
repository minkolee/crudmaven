package cc.conyli.controller;

import cc.conyli.entity.Customer;
import cc.conyli.test.CustomerErrorResponse;
import cc.conyli.test.CustomerNotfoundError;
import cc.conyli.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotfoundError("Customer with id " + customerId + " NOT FOUND!");
        }
        return customer;
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotfoundError customerNotfoundError) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage(customerNotfoundError.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleNormalException(Exception ex) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage(ex.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }
}






























