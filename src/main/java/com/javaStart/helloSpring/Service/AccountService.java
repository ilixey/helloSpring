package com.javaStart.helloSpring.Service;

import com.javaStart.helloSpring.Exception.AccountNotFoundException;
import com.javaStart.helloSpring.entity.Account;
import com.javaStart.helloSpring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String name, String email, Integer bill){
        Account account = new Account(name, email, bill);
        return accountRepository.save(account).getId();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found."));
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account deleteById(Long id){
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
        return account;
    }
}
