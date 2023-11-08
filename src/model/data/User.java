package model.data;

import java.util.Optional;

public class User {
    private String name;
    private String surname;
    private char[] password;
    private String status;
    private String role;
    private String nickname;

    public User(String name, String surname, String nickname, char[] password, String status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.role = "Client";
        this.nickname = nickname;
        this.password = password;
    }

    public User(String name, String surname, String nickname, char[] password, String status, String role) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.role = role;
        this.nickname = nickname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public char[] getPassword() {
        return password;
    }
}

//interfejs entity