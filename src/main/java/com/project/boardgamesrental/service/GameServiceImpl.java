package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Game;
import com.project.boardgamesrental.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public void updateGamePrice(Integer gameId, float price) {
        Optional<Game> currentGame = gameRepository.findById(gameId);

        if(currentGame.isPresent()){
            Game game = currentGame.get();
            game.setPrice(price);
            gameRepository.save(game);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + gameId);
        }
    }

    @Override
    public void updateGameIsRent(Integer gameId) {
        Optional<Game> currentGame = gameRepository.findById(gameId);

        if(currentGame.isPresent()){
            Game game = currentGame.get();
            // dajemy zanegowanego isRenta
            game.setRent(!game.isRent());
            gameRepository.save(game);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + gameId);
        }
    }

    @Override
    public void deleteGame(Integer gameId) {
        gameRepository.deleteById(gameId);
    }


}
