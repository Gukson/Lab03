package rental.data;

public class Ski {
    private String model;
    private Integer length;
    private String serialNumber;
    private Integer userID;
    private Integer price;
    private String status;
    private Integer isPaid;

    public Ski(String model, Integer length, String serialNumber, Integer price) {
        this.model = model;
        this.length = length;
        this.serialNumber = serialNumber;
        this.userID = 0;
        this.price = price;
        this.status = "Free";
        this.isPaid = 0;
    }
    public Ski(String model, Integer length, String serialNumber, Integer price, Integer userId, String status, Integer isPaid) {
        this.model = model;
        this.length = length;
        this.serialNumber = serialNumber;
        this.userID = userId;
        this.price = price;
        this.status = status;
        this.isPaid = isPaid;
    }

    public String getModel() {
        return model;
    }

    public Integer getLength() {
        return length;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Integer isPaid() {
        return isPaid;
    }
}
