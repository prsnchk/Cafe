package jdbc;

import connectionPool.DBCPDataSource;
import dao.CafeDao;
import model.Cafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CafeDaoImpl implements CafeDao {

    Logger logger = LogManager.getLogger(CafeDaoImpl.class);

    @Override
    public List<Cafe> getAll() {
        logger.info("Cafe - getAll() - called.");
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
            logger.info(Cafes);
            return Cafes;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cafe getEntityById(Integer id) {
        logger.info("Cafe - getEntityById() - called.");
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
            logger.info(receivedCafe);
            return receivedCafe;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Cafe cafe) {
        logger.info("Cafe - update() - called.");
        logger.info(cafe);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Cafe SET cafe_name = '"
                    + cafe.getCafeName() + "' WHERE id="
                    + cafe.getId() + ";");
        }
        catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        logger.info("Cafe - delete() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Cafe WHERE id=" + id);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Cafe cafe) {
        logger.info("Cafe - save() - called.");
        logger.info(cafe);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement =connection.createStatement();
            statement.execute("INSERT INTO Cafe (id, cafe_name) VALUES ("
                    + cafe.getId() + ", '"
                    + cafe.getCafeName() + "');");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
