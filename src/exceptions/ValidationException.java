package exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{

    private List<String> fieldsWithIssues;

    public ValidationException(List<String> fieldsWithIssues) {
        super();
        this.fieldsWithIssues = fieldsWithIssues;
    }

    @Override
    public String toString() {
        return String.join(", ", this.fieldsWithIssues);
    }

}