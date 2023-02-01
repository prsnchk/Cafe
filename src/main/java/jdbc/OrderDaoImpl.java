package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends Dao<Order, Integer> {

    CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    WaiterDaoImpl waiterDaoImpl = new WaiterDaoImpl();
    CafeDaoImpl cafeDaoImpl = new CafeDaoImpl();
    PaymentTypeDaoImpl paymentTypeDaoImpl = new PaymentTypeDaoImpl();

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM `Order`");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                Order newOrder = new Order();
                newOrder.setOrderID(rs.getInt("order_id"));
                newOrder.setPrice(rs.getInt("price"));
                //Customer
                int customerId = rs.getInt("customer_id");
                Customer customer = customerDaoImpl.getEntityById(customerId);
                newOrder.setCustomer(customer);
                //Waiter
                int waiterId = rs.getInt("waiter_id");
                Waiter waiter = waiterDaoImpl.getEntityById(waiterId);
                newOrder.setWaiter(waiter);
                //Cafe
                int cafeId = rs.getInt("cafe_id");
                Cafe cafe = cafeDaoImpl.getEntityById(cafeId);
                newOrder.setCafe(cafe);
                //PaymentType
                int paymentTypeId = rs.getInt("payment_type_id");
                PaymentType paymentType = paymentTypeDaoImpl.getEntityById(paymentTypeId);
                newOrder.setPaymentType(paymentType);
                orders.add(newOrder);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public Order getEntityById (Integer id) {
        Order receivedOrder= new Order();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM `Order` WHERE order_id = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedOrder.setOrderID(rs.getInt("order_id"));
                receivedOrder.setPrice(rs.getInt("price"));
                //Customer
                int customerId = rs.getInt("customer_id");
                Customer customer = customerDaoImpl.getEntityById(customerId);
                receivedOrder.setCustomer(customer);
                //Waiter
                int waiterId = rs.getInt("waiter_id");
                Waiter waiter = waiterDaoImpl.getEntityById(waiterId);
                receivedOrder.setWaiter(waiter);
                //Cafe
                int cafeId = rs.getInt("cafe_id");
                Cafe cafe = cafeDaoImpl.getEntityById(cafeId);
                receivedOrder.setCafe(cafe);
                //PaymentType
                int paymentTypeId = rs.getInt("payment_type_id");
                PaymentType paymentType = paymentTypeDaoImpl.getEntityById(paymentTypeId);
                receivedOrder.setPaymentType(paymentType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return receivedOrder;
    }

    @Override
    public void update(Order order) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE `Order` SET price= " + order.getPrice() + ", "
                    + "customer_id = " + order.getCustomer().getCustomerId() + ", "
                    + "waiter_id = " + order.getWaiter().getId() + ", "
                    + "cafe_id = " + order.getCafe().getId() + ", "
                    + "payment_type_id = " + order.getPaymentType().getIdPaymentType() + ", "
                    + "WHERE order_id= " + order.getOrderID() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Order order) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `Order` (order_id, price, customer_id, waiter_id, cafe_id, payment_type_id ) VALUES ("
                    + order.getOrderID() + ", "
                    + order.getPrice() + ", "
                    + order.getCustomer().getCustomerId() + ", "
                    + order.getWaiter().getId() + ", "
                    + order.getCafe().getId() + ", "
                    + order.getPaymentType().getIdPaymentType() + ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     @Override
     public void delete(Integer id) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM `Order` WHERE order_id=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

}
