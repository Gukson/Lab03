package rental.service.reservation;

import rental.exceptions.CreationException;
import rental.data.Reservation;
import rental.data.Ski;
import rental.data.User;

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
