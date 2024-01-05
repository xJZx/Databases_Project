package com.project.boardgamesrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowGamesController {

    @GetMapping("/showgames")
    public String showGames(){
        return "showgames";
    }
}
