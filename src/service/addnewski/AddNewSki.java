package service.addnewski;

import dao.StorageDao;
import exceptions.SaveNewSkiException;
import exceptions.ValidationException;
import model.data.Ski;

import java.util.ArrayList;
import java.util.List;

public class AddNewSki {

    private StorageDao storageDao;

    public AddNewSki(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public Ski AddNewSki(String serialNumber, Integer length, String model, Integer price){
        checkSerialNumber(serialNumber);
        validate(serialNumber,length,model,price);
        Ski s = new Ski(model, length, serialNumber, price);
        storageDao.create(s);

        return s;
    }

    private boolean checkSerialNumber(String sNumber){
        for(Ski s: storageDao.getAll())
        {
            if(s.getSerialNumber().equals(sNumber)){
                throw new SaveNewSkiException();
            }
        }
        return true;
    }

    private boolean validate(String serialNumber, Integer length, String model, Integer price) {
        List<String> fieldsWithErrors = new ArrayList<>();
        if (serialNumber.length() == 0) {
            fieldsWithErrors.add("serrialNumber");
        } if (length != 0) {
            fieldsWithErrors.add("length");
        }if(model.length() == 0){
            fieldsWithErrors.add("model");
        }if(price != 0){
            fieldsWithErrors.add("price");
        }
        if (fieldsWithErrors.isEmpty()) {
            return true;
        }
        throw new ValidationException(fieldsWithErrors);
    }
}
