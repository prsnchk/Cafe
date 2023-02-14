package jdbc;

import connectionPool.DBCPDataSource;
import dao.Dao;
import dao.MenuItemsDao;
import model.MenuItems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MenuItemsDaoImpl implements MenuItemsDao {

    @Override
    public List<MenuItems> getAll() {
        List<MenuItems> MenuItems = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Menu_Items");
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                MenuItems newMenuItems = new MenuItems();
                newMenuItems.setMenuId(rs.getInt("id_menu"));
                newMenuItems.setNameUkr(rs.getString("name_ukr"));
                newMenuItems.setNameEng(rs.getString("name_eng"));
                newMenuItems.setPrice(rs.getInt("price"));
            }
            return MenuItems;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MenuItems getEntityById (Integer id) {
        MenuItems receivedMenuItems = new MenuItems();
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Menu_items WHERE id_menu = " + id);
            ResultSet rs = statement.getResultSet();
            while(rs.next())
            {
                receivedMenuItems.setMenuId(rs.getInt("id_menu"));
                receivedMenuItems.setNameUkr(rs.getString("name_ukr"));
                receivedMenuItems.setNameEng(rs.getString("name_eng"));
                receivedMenuItems.setPrice(rs.getInt("price"));
            }
            return receivedMenuItems;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update (MenuItems menuItems) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Menu_items SET name_ukr = '" + menuItems.getNameUkr() + "', "
                    + "name_eng = '" + menuItems.getNameEng() + "', "
                    + "price = " + menuItems.getPrice() + ";");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(MenuItems menuItems) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Menu_items (id_menu, name_ukr, name_eng, price ) VALUES ("
                    + menuItems.getMenuId() + ", '"
                    + menuItems.getNameUkr() + "', '"
                    + menuItems.getNameEng() + "', "
                    + menuItems.getPrice() + ");");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBCPDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Menu_items WHERE id_menu=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
