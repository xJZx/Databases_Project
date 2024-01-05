package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Game;
import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.repository.AccountRepository;
import com.project.boardgamesrental.repository.GameRepository;
import com.project.boardgamesrental.repository.RentRepository;
import com.project.boardgamesrental.service.GameService;
import com.project.boardgamesrental.service.RentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class RentGameController {

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

    @PostMapping("/gamerent")
    public String gameRent(@RequestParam("gameId") int gameId, @ModelAttribute Rent rent, HttpSession session, Model model){
        Account account = (Account)session.getAttribute("account");
        if(account.isLogged()){
            Game game = gameRepository.findGameById(gameId);
            if(game != null && !game.isRent()){
                // dodanie account i game do rent
                rent.setAccount(account);
                rent.setGame(game);
                rentRepository.save(rent);
                // zmienienie statusu gry
                game.setRent(true);
                gameRepository.save(game);
                // dodanie renta do account
//                account.getRent().add(rent);
//                accountRepository.save(account);

                Iterable<Rent> rents = rentRepository.findAll();

                ArrayList<Rent> rentsToAccount = new ArrayList<>();
                for(Rent rent_iter : rents){
                    if(rent_iter.getAccount().getId() == account.getId()){
                        rentsToAccount.add(rent_iter);
                    }
                }

                model.addAttribute("rents", rentsToAccount);
            }
        }
        return "account";
    }
}
