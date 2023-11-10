package rental.data;

public class Ski {
    private String model;
    private Integer length;
    private String serialNumber;
    private Integer userID;
    private Integer price;

    public Ski(String model, Integer length, String serialNumber, Integer price) {
        this.model = model;
        this.length = length;
        this.serialNumber = serialNumber;
        this.userID = null;
        this.price = price;
    }
    public Ski(String model, Integer length, String serialNumber, Integer price, Integer userId) {
        this.model = model;
        this.length = length;
        this.serialNumber = serialNumber;
        this.userID = userId;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public Integer getLength() {
        return length;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Integer getUserID() {
        return userID;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getPrice() {
        return price;
    }
}
