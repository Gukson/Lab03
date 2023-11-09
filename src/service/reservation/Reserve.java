package service.reservation;

import exceptions.CreationException;
import model.data.Reservation;
import model.data.Ski;
import model.data.User;

public class Reserve {

    public void reservation(Ski ski, User user){
        if(ski.getActualOwner() != null){
            throw new CreationException();
        }
        Reservation reservation = new Reservation("Reserved", false,user);
        user.getReservations().add(reservation);
        ski.setActualOwner(user);
    }
}
