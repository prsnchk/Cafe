package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.LoyaltyCardDao;
import model.LoyaltyCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyCardDaoImpl implements LoyaltyCardDao {
    Logger logger = LogManager.getLogger(LoyaltyCardDaoImpl.class);


    @Override
    public List<LoyaltyCard> getAll() {
        logger.info("LoyaltyCard - getAll() - called.");
        List<LoyaltyCard> loyaltyCards = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM LoyaltyCard");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                LoyaltyCard newLoyaltyCard = new LoyaltyCard();
                newLoyaltyCard.setIdLoyaltyCard(rs.getInt("id_loyalty_card"));
                newLoyaltyCard.setDiscount(rs.getInt("discount"));
                newLoyaltyCard.setPointsBalance(rs.getString("points_balance"));
                loyaltyCards.add(newLoyaltyCard);
            }
            logger.info(loyaltyCards);
            return loyaltyCards;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public LoyaltyCard getEntityById(Integer id) {
        logger.info("LoyaltyCard - getEntityById() - called.");
        LoyaltyCard receivedLoyaltyCard= new LoyaltyCard();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM LoyaltyCard WHERE id_loyalty_card = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedLoyaltyCard.setIdLoyaltyCard(rs.getInt("id_loyalty_card"));
                receivedLoyaltyCard.setDiscount(rs.getInt("discount"));
                receivedLoyaltyCard.setPointsBalance(rs.getString("points_balance"));
            }
            logger.info(receivedLoyaltyCard);
            return receivedLoyaltyCard;
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }



    @Override
    public void update(LoyaltyCard loyaltyCard) {
        logger.info("LoyaltyCard - update() - called.");
        logger.info(loyaltyCard);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE LoyaltyCard SET discount = " + loyaltyCard.getDiscount() + ","
                    + "points_balance = " + loyaltyCard.getPointsBalance()
                    + " WHERE id_loyalty_card ="
                    + loyaltyCard.getIdLoyaltyCard() + ";");
        }
        catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(LoyaltyCard loyaltyCard) {
        logger.info("LoyaltyCard - save() - called.");
        logger.info(loyaltyCard);
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO LoyaltyCard (id_loyalty_card, discount, points_balance ) VALUES ("
                    + loyaltyCard.getIdLoyaltyCard() + ", "
                    + loyaltyCard.getDiscount() + ", "
                    + loyaltyCard.getPointsBalance() + ");");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        logger.info("LoyaltyCard - delete() - called.");
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM LoyaltyCard WHERE id_loyalty_card=" + id);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
