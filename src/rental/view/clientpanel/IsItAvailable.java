package rental.view.clientpanel;

import rental.dao.StorageDao;
import rental.data.Ski;
import rental.exceptions.DataSynchronizationException;

import java.util.List;

public class IsItAvailable {
    public Ski checkIsItAvailable(Ski ski, StorageDao storageDao){
        List<Ski> skis = storageDao.getAll();
        for(Ski s: skis){
            if(s.getSerialNumber().equals(ski.getSerialNumber()) && !s.getStatus().equals("Free")){
                throw new DataSynchronizationException();
            }
        }
        return ski;
    }
}
