package service;

import dao.CafeDaoImpl;
import model.Cafe;

import java.sql.Connection;
import java.util.List;

public class CafeService {
    CafeDaoImpl cafeDao = new CafeDaoImpl();

    public List<Cafe> getAllCafes(){
        return  cafeDao.getAll();
    }

    public Cafe getCafeById(int id){
        return cafeDao.getEntityById(id);
    }

    public void updateCafe(Cafe c){
        cafeDao.update(c);
    }

    public void saveCafe(Cafe c){
        cafeDao.save(c);
    }

    public void deleteCafe(Cafe c){
        cafeDao.delete(c.getId());
    }
}
