package service;

import dao.LoyaltyCardDaoImpl;
import model.LoyaltyCard;

import java.sql.Connection;
import java.util.List;

public class LoyaltyCardService {
    LoyaltyCardDaoImpl loyaltyCardDao = new LoyaltyCardDaoImpl();

    public List<LoyaltyCard> getAllLoyaltyCards(){
        return loyaltyCardDao.getAll();
    }

    public LoyaltyCard getLoyaltyCardById(int id){
        return loyaltyCardDao.getEntityById(id);
    }

    public void updateLoyaltyCard(LoyaltyCard lc){
        loyaltyCardDao.update(lc);
    }

    public void saveLoyaltyCard(LoyaltyCard lc){
        loyaltyCardDao.save(lc);
    }

    public void deleteLoyaltyCard(LoyaltyCard lc){
        loyaltyCardDao.delete(lc.getIdLoyaltyCard());
    }
}
