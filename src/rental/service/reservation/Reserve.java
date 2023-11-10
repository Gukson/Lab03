package rental.service.reservation;

import rental.dao.StorageDao;
import rental.exceptions.CreationException;
import rental.data.Ski;
import rental.data.User;

public class Reserve {

    public void reservation(Ski ski, StorageDao storageDao, User user){
        if(ski.getUserID() != 0){
            throw new CreationException();
        }
        storageDao.updateID(ski,user.getId());
        storageDao.update(ski,new String[]{"Status", "Reserved"});
    }
}
