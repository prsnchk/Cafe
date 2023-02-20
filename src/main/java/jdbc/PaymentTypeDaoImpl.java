package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.PaymentTypeDao;
import model.PaymentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDaoImpl implements PaymentTypeDao {
    Logger logger = LogManager.getLogger(PaymentTypeDaoImpl.class);


    @Override
    public List<PaymentType> getAll() {
        logger.info("PaymentType - getAll() - called.");
        List<PaymentType> PaymentTypes = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM PaymentType");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                PaymentType newPaymentType = new PaymentType();
                newPaymentType.setIdPaymentType(rs.getInt("id_payment_type"));
                newPaymentType.setName(rs.getString("name"));
                PaymentTypes.add(newPaymentType);
            }
            logger.info(PaymentTypes);
            return PaymentTypes;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaymentType getEntityById(Integer id) {
        logger.info("PaymentType - getEntityById() - called.");
        PaymentType receivedPaymentType  = new PaymentType ();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM PaymentType  WHERE id_payment_type = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedPaymentType.setIdPaymentType(rs.getInt("id_payment_type"));
                receivedPaymentType.setName(rs.getString("name"));
            }
            logger.info(receivedPaymentType);
            return receivedPaymentType;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PaymentType paymentType) {
        logger.info("PaymentType - update() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE PaymentType SET name = '"
                    + paymentType.getName() + "' WHERE id_payment_type="
                    + paymentType.getIdPaymentType() + ";");
        }
        catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(PaymentType paymentType) {
        logger.info("PaymentType - save() - called.");
        logger.info(paymentType);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO PaymentType (id_payment_type, name) VALUES ("
                    + paymentType.getIdPaymentType() + ", '"
                    + paymentType.getName() + "');");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        logger.info("PaymentType - delete() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM PaymentType WHERE id_payment_type=" + id);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
