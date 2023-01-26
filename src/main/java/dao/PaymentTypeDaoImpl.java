package dao;

import model.MenuItems;
import model.PaymentType;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDaoImpl extends Dao<PaymentType, Integer>{
    Connection connection = JdbcUtil.getConnection();

    @Override
    public List<PaymentType> getAll() {
        List<PaymentType> PaymentTypes = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM PaymentType");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                PaymentType newPaymentType = new PaymentType();
                newPaymentType.setIdPaymentType(rs.getInt("id_payment_type"));
                newPaymentType.setName(rs.getString("name"));
                PaymentTypes.add(newPaymentType);
            }
            return PaymentTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaymentType getEntityById(Integer id) {
        PaymentType receivedPaymentType  = new PaymentType ();
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM PaymentType  WHERE id_payment_type = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedPaymentType.setIdPaymentType(rs.getInt("id_payment_type"));
                receivedPaymentType.setName(rs.getString("name"));
            }
            return receivedPaymentType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PaymentType PaymentType) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("UPDATE PaymentType SET name = '"
                    + PaymentType.getName() + "' WHERE id_payment_type="
                    + PaymentType.getIdPaymentType() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(PaymentType PaymentType) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO PaymentType (id_payment_type, name) VALUES ("
                    + PaymentType.getIdPaymentType() + ", '"
                    + PaymentType.getName() + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM PaymentType WHERE id_payment_type=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
