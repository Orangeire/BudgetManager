package com.wldrmnd.menu;

import com.wldrmnd.contoller.AccountController;
import com.wldrmnd.entity.User;
import com.wldrmnd.entity.budget.CreditCard;

import java.util.Scanner;

public class AccountMenu {

    private Scanner in;
    private AccountController controller;

    public AccountMenu() {
        in = new Scanner(System.in);
        controller = new AccountController();
        menu();
    }

    private void menu() {
        printMenu();
        int choice = in.nextInt();
        if (choice == 1) {
            User userCredentials = inputCredentials();
            CreditCard creditCardFromConsole = new CreditCard();
            controller.setAccountCreditCard(userCredentials, creditCardFromConsole);
            System.out.println(controller.getAll());
        }
        else if (choice == 0)
            return;
        menu();
    }

    private User inputCredentials() {
        User userFromConsole = new User();
        System.out.println("Введи логин:");
        userFromConsole.setLogin(in.next());
        System.out.println("Введи пароль:");
        userFromConsole.setPassword(in.next());
        return userFromConsole;
    }

    private void printMenu() {
        System.out.println("Выбери опцию:");
        System.out.println("1) Добавить карту");
        System.out.println("0) Выйти");
    }
    private void printAuthorizationMenu() {
        System.out.println("Ты опять попал в хуевый банк:)");
        System.out.println("1) Зарегистрироваться");
        System.out.println("2) Войти");
    }


}
