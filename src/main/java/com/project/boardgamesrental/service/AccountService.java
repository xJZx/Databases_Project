package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Rent;

import java.util.List;

public interface AccountService {
    public Account saveAccount(Account account);
    public List<Account> getAllAccounts();
    public void updateAccountPhoneNumber(Integer accountId, String phoneNumber);
    public void loginAccount(String email, String password);
    public void logoutAccount(Integer accountId);
    public void deleteAccount(Integer accountId);
    public boolean isNineDigitPhoneNumber(String phoneNumber);
    public boolean isValidEmail(String email);
    public boolean isPasswordValid(String password);

    // metody pomocnicze
    public List<Rent> getAllRentsForClient(Integer clientId);
}
