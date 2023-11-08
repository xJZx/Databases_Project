package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Customer;
import com.project.boardgamesrental.service.CustomerService;
import jakarta.persistence.Entity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String add(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "New customer added";
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestBody Customer customer){
        customerService.deleteCustomer(customer.getId());
        return "Customer deleted";
    }

    @PatchMapping("/update")
    public String updateCustomer(@RequestBody Customer customer){
        String newPhoneNumber = customer.getPhoneNumber();
        customerService.updateCustomer(customer.getId(), newPhoneNumber);
//        customerService.saveCustomer(customer);
        return "Customer's phone number updated!";
    }

}
