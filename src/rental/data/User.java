package rental.data;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private char[] password;
    private String status;
    private String role;
    private String nickname;
    private List<Reservation> reservations;
    private Integer id;


    public User(String name, String surname, String nickname, char[] password, String status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.role = "Client";
        this.nickname = nickname;
        this.password = password;
        this.reservations = new ArrayList<>();
    }

    public User(String name, String surname, String nickname, char[] password, String status, String role, Integer id) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.role = role;
        this.nickname = nickname;
        this.password = password;
        this.reservations = new ArrayList<>();
        this.id = id;
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

    public char[] getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

}

//interfejs entity