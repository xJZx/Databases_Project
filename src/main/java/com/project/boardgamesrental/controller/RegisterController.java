package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.repository.AccountRepository;
import com.project.boardgamesrental.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute Account account){
        if(accountRepository.findByEmail(account.getEmail()) != null){
            return "register";
        }

        accountService.saveAccount(account);
        System.out.println(account.toString());
        return "index";
    }
}
