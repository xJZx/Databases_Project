package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Customer;
import com.project.boardgamesrental.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Integer customerId, String newPhoneNumber){
        Optional<Customer> currentCustomer = customerRepository.findById(customerId);

        if (currentCustomer.isPresent()) {
            Customer customer = currentCustomer.get();
            customer.setPhoneNumber(newPhoneNumber);
            customerRepository.save(customer);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + customerId);
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
