package com.wldrmnd.service;

import com.wldrmnd.entity.Account;
import com.wldrmnd.entity.User;
import com.wldrmnd.entity.budget.CreditCard;
import com.wldrmnd.repo.AccountRepo;


import java.util.List;

//могу измнеить имя, фамилию, добавить карточку к аккаунта
public class AccountService {

    private AccountRepo accountRepo;

    public AccountService() {
        accountRepo = new AccountRepo();
    }

    public void addAccount(Account account) {
        accountRepo.add(account);
    }

    public boolean setName(User user, String name) {
        for (Account oldAccount : accountRepo.getAll()) {
            if (isUserCredentialsCorrect(user, oldAccount)) {
                Account newAccount = new Account();
                newAccount.setName(name);
                newAccount.setBalance(oldAccount.getBalance());
                newAccount.setSurname(oldAccount.getSurname());
                newAccount.setLogin(oldAccount.getLogin());
                newAccount.setPassword(oldAccount.getPassword());

                accountRepo.remove(oldAccount);
                accountRepo.add(newAccount);
                return true;
            }
        }
        return false;
    }

    public boolean setSurname(User user, String surname) {
        for (Account account : accountRepo.getAll()) {
            if (isUserCredentialsCorrect(user, account)) {
                account.setSurname(surname);
                return true;
            }
        }
        return false;
    }

    public boolean addCreditCard(User user, CreditCard creditCard) {
        for (Account account : accountRepo.getAll()) {
            if (isUserCredentialsCorrect(user, account)) {
                account.getBalance().setCreditCard(creditCard);
                return true;
            }
        }
        return false;
    }

    private boolean isUserCredentialsCorrect(User user, Account account) {
        return user.getLogin().equals(account.getLogin()) &&
                user.getPassword().equals(account.getPassword());
    }

    public List<Account> getAll() {
        return accountRepo.getAll();
    }
}
