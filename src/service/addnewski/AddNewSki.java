package service.addnewski;

import dao.StorageDao;
import exceptions.SaveNewSkiException;
import model.data.Ski;

public class AddNewSki {

    private StorageDao storageDao;

    public AddNewSki(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public Ski AddNewSki(String serialNumber, Integer length, String model){
        checkSerialNumber(serialNumber);
        Ski s = new Ski(model, length, serialNumber);
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
