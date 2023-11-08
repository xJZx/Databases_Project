package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public void updateCustomer(Integer customerId, String phoneNumber);
    public void deleteCustomer(Integer customerId);
}
