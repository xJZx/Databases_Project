package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.repository.AccountRepository;
import com.project.boardgamesrental.repository.RentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RentRepository rentRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void updateAccountPhoneNumber(Integer customerId, String newPhoneNumber){
        Optional<Account> currentAccount = accountRepository.findById(customerId);

        if (currentAccount.isPresent()) {
            Account account = currentAccount.get();
            account.setPhoneNumber(newPhoneNumber);
            accountRepository.save(account);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + customerId);
        }
    }

    @Override
    public void loginAccount(String email, String password) {
        List<Account> currentListAccount = accountRepository.findAll();

        for (int i = 0; i < currentListAccount.size(); i++) {
            if(currentListAccount.get(i).getEmail().equals(email)){
                if(currentListAccount.get(i).getPassword().equals(password)){
                    Account account = currentListAccount.get(i);

                    account.setLogged(!account.isLogged());
                    accountRepository.save(account);
                }
            }
        }
    }

    @Override
    public void logoutAccount(Integer accountId){
        Optional<Account> currentAccount = accountRepository.findById(accountId);

        if (currentAccount.isPresent()) {
            Account account = currentAccount.get();
            account.setLogged(!account.isLogged());
            accountRepository.save(account);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + accountId);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Rent> getAllRentsForClient(Integer clientId) {
        Optional<Account> currentAccount = accountRepository.findById(clientId);

        if (currentAccount.isPresent()) {
            Account account = currentAccount.get();
            return rentRepository.findAllById(Collections.singleton(account.getId()));
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + clientId);
        }
    }
}
