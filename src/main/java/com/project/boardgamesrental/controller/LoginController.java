package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.repository.AccountRepository;
import com.project.boardgamesrental.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session){
        Account account = accountRepository.findByEmail(email);

        if(account != null && account.getPassword().equals(password) && !account.isLogged()){
            account.setLogged(!account.isLogged());
            accountRepository.save(account);
            session.setAttribute("account", account);
            System.out.println("Logged in!");
            return "index";
        }
        else if(account != null && account.getPassword().equals(password) && account.isLogged()){
            session.setAttribute("account", account);
            System.out.println("Already logged in!");
            return "index";
        }
        else{
            System.out.println("Error!");
            return "login";
        }
    }
}
