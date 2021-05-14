package service;

import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class UserService {
    static Scanner s = new Scanner(System.in);

    public static User createUser() {
        User user = new User();
        boolean isActive = true;

        while (isActive) {
            try {
                System.out.println("Enter full name: ");
                String fName = s.nextLine();
                user.setFullName(fName);
                isActive = false;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        isActive = true;

        while (isActive) {
            try {
                System.out.println("Enter username: ");
                String UName = s.next();
                user.setUsername(UName);
                isActive = false;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        isActive = true;

        while (isActive) {
            try {
                System.out.println("Enter email: ");
                String email = s.next();
                user.setEmail(email);
                isActive = false;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        isActive = true;

        while (isActive) {
            try {
                System.out.println("Enter password: ");
                String password = s.next();
                user.setPassword(password);
                isActive = false;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public static boolean checkingDuplicates(String path, String username) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(path));
        boolean isContains = false;

        for (String s : strings) {
            String[] split = s.split(",");
            if (split[1].equals(username)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
