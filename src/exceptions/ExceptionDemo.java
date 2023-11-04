package exceptions;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.channels.FileLockInterruptionException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionDemo {

    public static void main(String[] args) {
        String s = "aaaaa";
        if (isNumeric(s)) {
            int i = Integer.parseInt("6");
        } else {
            int i = 0;
        }
        boolean succesfullyWriten = false;
        while (!succesfullyWriten) {
            try {
                boolean exists = checkIfFileExists("/abcd");
                System.out.println("Write to database");
                succesfullyWriten =true;
            } catch (FileNotFoundException e) {
                succesfullyWriten = false;
            }
        }
    }

    private static boolean isNumeric(String s) {
        throw new CustomNonCheckedException(s, new BigDecimal("12345.0989712"));
    }

    private static boolean checkIfFileExists(String path) throws FileNotFoundException{
        if (path.startsWith("/abc")) {
            return true;
        }
        throw new FileNotFoundException();
    }
}