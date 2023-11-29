package com.project.boardgamesrental.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "GAME_ID", updatable = false, insertable = false)
    private int gameId;
    @Column(name = "CLIENT_ID", updatable = false, insertable = false)
    private int clientId;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date rentDate;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Account account;

    @OneToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

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
