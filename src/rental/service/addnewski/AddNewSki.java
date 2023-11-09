package rental.service.addnewski;

import rental.dao.StorageDao;
import rental.exceptions.SaveNewSkiException;
import rental.exceptions.ValidationException;
import rental.data.Ski;

import java.util.ArrayList;
import java.util.List;

public class AddNewSki {

    private StorageDao storageDao;

    public AddNewSki(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void AddNewSki(String serialNumber, String length, String model, String price){
        validate(serialNumber,length,model,price);
        checkSerialNumber(serialNumber);

        storageDao.create(new Ski(model, Integer.parseInt(length), serialNumber, Integer.parseInt(price)));
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

    private boolean validate(String serialNumber, String length, String model, String price) {
        List<String> fieldsWithErrors = new ArrayList<>();
        if (serialNumber.isEmpty()) {
            fieldsWithErrors.add("serrialNumber");
        } if (length.isEmpty()) {
            fieldsWithErrors.add("length");
        }if(model.isEmpty()){
            fieldsWithErrors.add("rental/model");
        }if(price.isEmpty()){
            fieldsWithErrors.add("price");
        }
        if (fieldsWithErrors.isEmpty()) {
            return true;
        }
        throw new ValidationException(fieldsWithErrors);
    }
}
