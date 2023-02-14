package jdbc;

import connectionPool.DBCPDataSource;
import dao.CafeDao;
import dao.Dao;
import model.Cafe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CafeDaoImpl implements CafeDao {

    @Override
    public List<Cafe> getAll() {
        List<Cafe> Cafes = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Cafe");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                Cafe newCafe = new Cafe();
                newCafe.setId(rs.getInt("id"));
                newCafe.setCafeName(rs.getString("cafe_name"));
                Cafes.add(newCafe);
            }
            return Cafes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cafe getEntityById(Integer id) {
        Cafe receivedCafe  = new Cafe ();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Cafe  WHERE id = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedCafe.setId(rs.getInt("id"));
                receivedCafe.setCafeName(rs.getString("cafe_name"));
            }
            return receivedCafe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Cafe cafe) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Cafe SET cafe_name = '"
                    + cafe.getCafeName() + "' WHERE id="
                    + cafe.getId() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Cafe WHERE id=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Cafe cafe) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Cafe (id, cafe_name) VALUES ("
                    + cafe.getId() + ", '"
                    + cafe.getCafeName() + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
