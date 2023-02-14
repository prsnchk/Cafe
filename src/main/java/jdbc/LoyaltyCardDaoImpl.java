package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.LoyaltyCardDao;
import model.LoyaltyCard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyCardDaoImpl implements LoyaltyCardDao {


    @Override
    public List<LoyaltyCard> getAll() {
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
            return loyaltyCards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LoyaltyCard getEntityById(Integer id) {
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
            return receivedLoyaltyCard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void update(LoyaltyCard loyaltyCard) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE LoyaltyCard SET discount = " + loyaltyCard.getDiscount() + ","
                    + "points_balance = " + loyaltyCard.getPointsBalance()
                    + " WHERE id_loyalty_card ="
                    + loyaltyCard.getIdLoyaltyCard() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(LoyaltyCard loyaltyCard) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO LoyaltyCard (id_loyalty_card, discount, points_balance ) VALUES ("
                    + loyaltyCard.getIdLoyaltyCard() + ", "
                    + loyaltyCard.getDiscount() + ", "
                    + loyaltyCard.getPointsBalance() + ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM LoyaltyCard WHERE id_loyalty_card=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
