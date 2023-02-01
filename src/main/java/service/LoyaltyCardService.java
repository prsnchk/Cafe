package service;

import jdbc.LoyaltyCardDaoImpl;
import model.LoyaltyCard;

import java.util.List;

public class LoyaltyCardService {
    LoyaltyCardDaoImpl loyaltyCardDao = new LoyaltyCardDaoImpl();

    public List<LoyaltyCard> getAllLoyaltyCards(){
        return loyaltyCardDao.getAll();
    }

    public LoyaltyCard getLoyaltyCardById(int id){
        return loyaltyCardDao.getEntityById(id);
    }

    public void updateLoyaltyCard(LoyaltyCard loyaltyCard){
        loyaltyCardDao.update(loyaltyCard);
    }

    public void saveLoyaltyCard(LoyaltyCard loyaltyCard){
        loyaltyCardDao.save(loyaltyCard);
    }

    public void deleteLoyaltyCard(LoyaltyCard loyaltyCard){
        loyaltyCardDao.delete(loyaltyCard.getIdLoyaltyCard());
    }
}
