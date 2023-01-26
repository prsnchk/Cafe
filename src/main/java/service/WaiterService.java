package service;

import dao.WaiterDaoImpl;
import model.Waiter;

import java.sql.Connection;
import java.util.List;

public class WaiterService {
    WaiterDaoImpl waiterDao = new WaiterDaoImpl();

    public List<Waiter> getAllWaiters(){
        return waiterDao.getAll();
    }

    public Waiter getWaiterById(int id){
        return waiterDao.getEntityById(id);
    }

    public void updateWaiter(Waiter waiter){
        waiterDao.update(waiter);
    }

    public void saveWaiter(Waiter waiter){
        waiterDao.save(waiter);
    }

    public void deleteWaiter(Waiter waiter){
        waiterDao.delete(waiter.getId());
    }


}
