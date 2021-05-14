package service;

import model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MenuService {
    static Scanner s = new Scanner(System.in);
    private final static int LOGIN = 1;
    private final static int REGISTER = 2;
    private final static int EXIT = 0;

    public static void startMenu(boolean isActive) {
        while (isActive) {
            System.out.println("Enter command: ");
            System.out.println("1. login");
            System.out.println("2. registration");
            System.out.println("0. exit");

            int command = s.nextInt();

            switch (command) {
                case LOGIN -> loginMenu();
                case REGISTER -> regMenu();
                case EXIT -> isActive = false;
                default -> System.out.println("Invalid command!");
            }
        }
    }

    private static void loginMenu() {
        try {
            boolean b = FileService.checkingLoginInfo();
            System.out.println(b ? "login success!" : "invalid input data!");
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void regMenu() {
        User user = UserService.createUser();
        try {
            FileService.addUserToFile("Users.txt", user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
