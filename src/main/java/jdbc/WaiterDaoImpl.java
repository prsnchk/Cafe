package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.WaiterDao;
import model.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WaiterDaoImpl implements WaiterDao {

    Logger logger = LogManager.getLogger( WaiterDaoImpl.class);


    @Override
    public List<Waiter> getAll() {
        logger.info("Waiter - getAll() - called.");
        List<Waiter> waiters = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Waiter");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                Waiter newWaiter = new Waiter();
                newWaiter.setId(rs.getInt("id"));
                newWaiter.setFirstName(rs.getString("first_name"));
                waiters.add(newWaiter);
            }
            logger.info(waiters);
            return waiters;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Waiter getEntityById(Integer id) {
        logger.info("Waiter - getEntityById() - called.");
        Waiter receivedWaiter = new Waiter();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Waiter WHERE id = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedWaiter.setId(rs.getInt("id"));
                receivedWaiter.setFirstName(rs.getString("first_name"));
            }
            logger.info(receivedWaiter);
            return receivedWaiter;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Waiter waiter) {
        logger.info("Waiter - update() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Waiter SET first_name = '"
                    + waiter.getFirstName() + "' WHERE id ="
                    + waiter.getId() + ";");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Waiter waiter) {
        logger.info("Waiter - save() - called.");
        logger.info(waiter);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Waiter (id, first_name) VALUES ("
                    + waiter.getId() + ", '"
                    + waiter.getFirstName() + "');");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        logger.info("Waiter - delete() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Waiter WHERE id=" + id);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
