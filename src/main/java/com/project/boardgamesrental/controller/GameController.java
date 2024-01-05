package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Game;
import com.project.boardgamesrental.repository.GameRepository;
import com.project.boardgamesrental.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/addGame")
    public String add(@RequestBody Game game){
        gameService.saveGame(game);
        return "New game added";
    }

    @GetMapping("/getAllGames")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @PostMapping("/showgames")
    public String showGames(Model model){
        Iterable<Game> games = gameRepository.findAll();

        model.addAttribute("games", games);

        return "showgames";
    }

    @DeleteMapping("/deleteGame")
    public String deleteGame(@RequestBody Game game){
        gameService.deleteGame(game.getId());
        return "Game deleted";
    }

    @PatchMapping("/updatePrice")
    public String updateGamePrice(@RequestBody Game game){
        float newPrice = game.getPrice();
        gameService.updateGamePrice(game.getId(), newPrice);

        return "Game's price changed";
    }

    @PostMapping("/updateRent")
    public String updateGameRent(@RequestBody Game game) {
        gameService.updateGameIsRent(game.getId());

        return "Game's rent status changed";
    }
}
