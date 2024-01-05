package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Game;
import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.repository.AccountRepository;
import com.project.boardgamesrental.repository.GameRepository;
import com.project.boardgamesrental.repository.RentRepository;
import com.project.boardgamesrental.service.AccountService;
import com.project.boardgamesrental.service.GameService;
import com.project.boardgamesrental.service.RentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RentService rentService;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

//    @PostMapping("/add")
//    public String add(@RequestBody Account account){
//        accountService.saveAccount(account);
//        return "New customer added";
//    }

    @GetMapping("/account")
    public String account(Model model, HttpSession session){
        if(session.getAttribute("account") != null){
            Account account = (Account) session.getAttribute("account");


            Iterable<Rent> rents = rentRepository.findAll();

            ArrayList<Rent> rentsToAccount = new ArrayList<>();
            for(Rent rent : rents){
                if(rent.getAccount().getId() == account.getId()){
                    rentsToAccount.add(rent);
                }
            }

            model.addAttribute("rents", rentsToAccount);
            return "account";
        }
        else{
            return "login";
        }
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

//    @PatchMapping("/login")
//    public String loginAccount(@RequestBody Account account){
//        accountService.loginAccount(account.getEmail(), account.getPassword());
//        return "Account's logged in!";
//    }
//
//    @PatchMapping("/logout")
//    public String logoutAccount(@RequestBody Account account){
//        accountService.logoutAccount(account.getId());
//        return "Account's logged out!";
//    }

}
