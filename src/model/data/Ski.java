package model.data;

public class Ski {
    private String model;
    private boolean isBusy;
    private Integer length;

    public Ski(String model, boolean isBusy, Integer length) {
        this.model = model;
        this.isBusy = isBusy;
        this.length = length;
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
}
