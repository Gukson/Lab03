package rental.data;

public class Reservation {
    String status;
    boolean isPaid;
    Integer ownerID;
    String serialNumberOfSki;

    public Reservation(String status, boolean isPaid, Integer owner, String serialNumberOfSki) {
        this.status = status;
        this.isPaid = isPaid;
        this.ownerID = ownerID;
        this.serialNumberOfSki = serialNumberOfSki;
    }
}
