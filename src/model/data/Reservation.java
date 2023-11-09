package model.data;

import java.util.Date;

public class Reservation {
    String status;
    boolean isPaid;
    User owner;

    public Reservation(String status, boolean isPaid, User owner) {
        this.status = status;
        this.isPaid = isPaid;
        this.owner = owner;
    }
}
