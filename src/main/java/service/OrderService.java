package service;

import jdbc.OrderDaoImpl;
import model.Order;

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

    public void deleteOrder(Order o){
        orderDao.delete(o.getOrderID());
    }
}
