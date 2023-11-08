package model.data;

public class Ski {
    private String model;
    private boolean isBusy;
    private Integer length;
    private String serialNumber;
    private User actualOwner;
    private Reservation reservation;

    public Ski(String model, Integer length, String serialNumber) {
        this.model = model;
        this.isBusy = false;
        this.length = length;
        this.serialNumber = serialNumber;
        this.actualOwner = null;
        this.reservation = null;
    }

    public String getModel() {
        return model;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Integer getLength() {
        return length;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public User getActualOwner() {
        return actualOwner;
    }

    public void setActualOwner(User actualOwner) {
        this.actualOwner = actualOwner;
    }
}
