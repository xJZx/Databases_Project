package com.project.boardgamesrental.repository;

import com.project.boardgamesrental.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findGameById(Integer gameId);
}
