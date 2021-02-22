package com.wldrmnd.service;

import com.wldrmnd.entity.Account;
import com.wldrmnd.entity.User;
import com.wldrmnd.repo.AccountRepo;

public class AuthorizationService {

    private AccountRepo repo;

    public boolean signIn(User user) {
        for (Account accountToSignIn : repo.getAll()) {
            if (user.getLogin().equals(accountToSignIn.getLogin()) &&
                    user.getPassword().equals(accountToSignIn.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean signUp(User user) {
        //TODO!! checker
        for (int i = 0; i < repo.getAll().size(); i++) {
            if (user.getLogin().equals(repo.getAll().get(i).getLogin())) {
                System.out.println("Пользователь с таким логином уже существует");
                return false;
            }
        }
        repo.add(new Account(user));
        return true;
    }
}
