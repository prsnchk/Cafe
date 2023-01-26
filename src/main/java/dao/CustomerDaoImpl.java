package dao;

import model.Customer;
import model.LoyaltyCard;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends Dao<Customer, Integer> {
    Connection connection = JdbcUtil.getConnection();
    LoyaltyCardDaoImpl loyaltyCardDaoImpl = new LoyaltyCardDaoImpl();

    //Отримати всіх клієнтів
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM Customer");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                Customer newCustomer = new Customer();
                newCustomer.setCustomerId(rs.getInt("id_customer"));
                newCustomer.setFirstName(rs.getString("first_name"));
                newCustomer.setSecondName(rs.getString("second_name"));
                newCustomer.setPhone(rs.getString("phone"));
                newCustomer.setEmail(rs.getString("email"));
                //LoyaltyCard
                int lcId = rs.getInt("loyalty_card_id");
                LoyaltyCard lc = loyaltyCardDaoImpl.getEntityById(lcId);
                newCustomer.setLoyaltyCard(lc);

                customers.add(newCustomer);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Отримати клієнта за ідентифікатором
    @Override
    public Customer getEntityById (Integer id) {
        Customer receivedCustomer = new Customer();
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM Customer WHERE id_customer = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedCustomer.setCustomerId(rs.getInt("id_customer"));
                receivedCustomer.setFirstName(rs.getString("first_name"));
                receivedCustomer.setSecondName(rs.getString("second_name"));
                receivedCustomer.setPhone(rs.getString("phone"));
                receivedCustomer.setEmail(rs.getString("email"));
                //LoyaltyCard
                int lcId = rs.getInt("loyalty_card_id");
                LoyaltyCard lc = loyaltyCardDaoImpl.getEntityById(lcId);
                receivedCustomer.setLoyaltyCard(lc);
            }
            return receivedCustomer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Оновити клієнта
    @Override
    public void update (Customer customer) {
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute("UPDATE Customer SET first_name = '" + customer.getFirstName() + "', "
                            + "second_name = '" + customer.getSecondName() + "', "
                            + "phone = '" + customer.getPhone() + "', "
                            + "email = '" + customer.getEmail() + "', "
                            + "loyalty_card_id = " + customer.getLoyaltyCard().getIdLoyaltyCard() + " "
                            + "WHERE id_customer = " + customer.getCustomerId() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Зберегти кліента
    @Override
    public void save(Customer customer) {
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO Customer (id_customer, first_name, second_name, phone, email, loyalty_card_id ) VALUES ("
                    + customer.getCustomerId() + ", '"
                    + customer.getFirstName() + "', '"
                    + customer.getSecondName() + "', '"
                    + customer.getPhone() + "', '"
                    + customer.getEmail() + "', "
                    + customer.getLoyaltyCard().getIdLoyaltyCard() + ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //Видалити клієнта
    @Override
    public void delete(Integer id) {
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM Customer WHERE id_customer=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

