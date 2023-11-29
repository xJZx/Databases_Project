package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Rent;

import java.util.List;

public interface AccountService {
    public Account saveAccount(Account account);
    public List<Account> getAllAccounts();
    public void updateAccountPhoneNumber(Integer accountId, String phoneNumber);
    public void updateIsLogged(Integer accountId);
    public void deleteAccount(Integer accountId);

    // metody pomocnicze
    public List<Rent> getAllRentsForClient(Integer clientId);
}
