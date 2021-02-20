package com.wldrmnd.entity;

import com.wldrmnd.entity.budget.Balance;
import java.io.Serializable;


//зарегистрироваться
//логин
//добавить деньги (кеш или картa), если карта - то привязать кредитку (можно только одну)
//добавить трата (пицца, шлюха, квартира)
//добавить долг (мне должен кто-то)
//вывести траты за определеннный промежуток
public class Account extends User implements Serializable, Cloneable {

    private String name;
    private String surname;
    private Balance balance;

    public Account(User user) {
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        name = "Undefined";
        surname = "Undefined";
        balance = new Balance();
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
