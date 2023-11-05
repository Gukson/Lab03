package exceptions;

public class CustomNonCheckedException extends RuntimeException{

    private String message;
    private Object dataStorage;

    public CustomNonCheckedException(String message, Object dataStorage) {
        super();
        this.message = message;
        this.dataStorage = dataStorage;
    }

    @Override
    public String toString() {
        return "CustomNonCheckedException{" +
                "message='" + message + '\'' +
                ", dataStorage=" + dataStorage +
                '}';
    }

    public String getLabelText() {
        return this.message;
    }
}
