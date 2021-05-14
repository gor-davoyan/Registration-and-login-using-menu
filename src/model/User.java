package model;

import service.MD5;
import service.UserService;

import java.io.IOException;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.matches("(\\b[A-Z][a-z]+)( )([A-Z][a-z]+\\b)"))
            this.fullName = fullName;
        else
            throw new RuntimeException("Invalid full name! Try again.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        try {
            if (username.length() < 10) {
                throw new RuntimeException("Invalid username! Try again.");
            } else if (UserService.checkingDuplicates("Users.txt", username)) {
                throw new RuntimeException("This username already exists! Choose someone else.");
            } else {
                this.username = username;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("^(.+)@(.+)$"))
            this.email = email;
        else
            throw new RuntimeException("Invalid email! Try again.");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.matches("^(?=(?:.*[A-Z].*){2})(?=(?:.*\\d.*){3}).*$"))
            this.password = MD5.hash(password);
        else
            throw new RuntimeException("Invalid password! Try again.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName)
                .append(",")
                .append(username)
                .append(",")
                .append(email)
                .append(",")
                .append(password);

        return sb.toString();
    }
}
