package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Game;
import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.repository.RentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RentRepository rentRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/games")
    public String games(){
        return "games";
    }

    @RequestMapping("/rentgame")
    public String rentgame(){
        return "rentgame";
    }

    @RequestMapping("/account")
    public String account(HttpSession session){
        if(session.getAttribute("account") != null){
            return "account";
        }
        else{
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
