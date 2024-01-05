package com.project.boardgamesrental.repository;

import com.project.boardgamesrental.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {
    Rent findByGameId(Integer gameId);
    Rent findByAccountId(Integer accountId);
}
