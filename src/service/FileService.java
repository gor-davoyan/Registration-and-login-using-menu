package service;

import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class FileService {
    static Scanner s = new Scanner(System.in);

    public static boolean checkingLoginInfo() throws IOException, NoSuchAlgorithmException {

        System.out.println("Enter username: ");
        String username = s.next();

        System.out.println("Enter password: ");
        String password = s.next();

        List<String> strings = Files.readAllLines(Paths.get("Users.txt"));
        boolean isContains = false;

        for (String next : strings) {
            String[] split = next.split(",");
            if (split[1].equals(username) && split[3].equals(MD5.hash(password))) {
                isContains = true;
            }
        }
        return isContains;
    }

    public static void addUserToFile(String path, User user) throws IOException {
        String u = user.toString() + "\n";
        Files.write(Paths.get(path), u.getBytes(), StandardOpenOption.APPEND);
    }
}
