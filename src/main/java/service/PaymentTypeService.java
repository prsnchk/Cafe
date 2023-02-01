package service;

import jdbc.PaymentTypeDaoImpl;
import model.PaymentType;

import java.util.List;

public class PaymentTypeService {
    PaymentTypeDaoImpl paymentTypeDao = new PaymentTypeDaoImpl();

    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeDao.getAll();
    }

    public PaymentType getPaymentTypeById(int id){
        return paymentTypeDao.getEntityById(id);
    }

    public  void updatePaymentType(PaymentType pt) {
        paymentTypeDao.update(pt);
    }

    public void savePaymentType(PaymentType pt){
        paymentTypeDao.save(pt);
    }

    public void deletePaymentType(PaymentType pt){paymentTypeDao.delete(pt.getIdPaymentType());
    }
}
