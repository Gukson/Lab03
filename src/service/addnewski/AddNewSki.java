package service.addnewski;

import dao.StorageDao;
import exceptions.SaveNewSkiException;
import model.data.Ski;

public class AddNewSki {

    private StorageDao storageDao;

    public AddNewSki(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public Ski AddNewSki(String serialNumber, Integer length, String model, Integer price){
        checkSerialNumber(serialNumber);
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

}
