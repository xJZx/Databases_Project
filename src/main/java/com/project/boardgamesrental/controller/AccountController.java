package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public String add(@RequestBody Account account){
        accountService.saveAccount(account);
        return "New customer added";
    }

    @GetMapping("/getAll")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @DeleteMapping("/delete")
    public String deleteAccount(@RequestBody Account account){
        accountService.deleteAccount(account.getId());
        return "Customer deleted";
    }

    @PatchMapping("/updatePhoneNumber")
    public String updateAccountPhoneNumber(@RequestBody Account account){
        String newPhoneNumber = account.getPhoneNumber();
        accountService.updateAccountPhoneNumber(account.getId(), newPhoneNumber);
//        customerService.saveCustomer(customer);
        return "Customer's phone number updated!";
    }

    @PatchMapping("/login")
    public String loginAccount(@RequestBody Account account){
        accountService.loginAccount(account.getEmail(), account.getPassword());
        return "Account's logged in!";
    }

    @PatchMapping("/logout")
    public String logoutAccount(@RequestBody Account account){
        accountService.logoutAccount(account.getId());
        return "Account's logged out!";
    }

}
