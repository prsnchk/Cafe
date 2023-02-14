package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.WaiterDao;
import model.Waiter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WaiterDaoImpl implements WaiterDao {

    @Override
    public List<Waiter> getAll() {
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
            return waiters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Waiter getEntityById(Integer id) {
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
            return receivedWaiter;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Waiter waiter) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Waiter SET first_name = '"
                    + waiter.getFirstName() + "' WHERE id ="
                    + waiter.getId() + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Waiter waiter) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Waiter (id, first_name) VALUES ("
                    + waiter.getId() + ", '"
                    + waiter.getFirstName() + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Waiter WHERE id=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
