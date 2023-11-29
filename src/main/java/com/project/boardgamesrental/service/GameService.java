package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Game;

import java.util.List;

public interface GameService {
    public Game saveGame(Game game);
    public List<Game> getAllGames();
    public void updateGamePrice(Integer gameId, float price);
    public void updateGameIsRent(Integer gameId);
    public void deleteGame(Integer gameId);
}
