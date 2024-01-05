package com.project.boardgamesrental.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "GAME_ID")
//    private int gameId;
//    @Column(name = "ACCOUNT_ID")
//    private int accountId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(int gameId) {
//        this.gameId = gameId;
//    }
//
//    public int getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(int clientId) {
//        this.accountId = clientId;
//    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
