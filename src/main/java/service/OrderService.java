package service;

import dao.OrderDaoImpl;
import model.Order;

import java.sql.Connection;
import java.util.List;

public class OrderService {
    OrderDaoImpl orderDao = new OrderDaoImpl();

    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    public Order getOrderId(int id){
        return orderDao.getEntityById(id);
    }

    public  void updateOrder(Order o) {
        orderDao.update(o);
    }

    public void saveOrder(Order o){
        orderDao.save(o);
    }

    public void deletePaymentType(Order o){
        orderDao.delete(o.getOrderID());
    }
}
