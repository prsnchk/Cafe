package dao;

import model.MenuItems;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MenuItemsDaoImpl extends Dao<MenuItems, Integer>{
    Connection connection = JdbcUtil.getConnection();

    @Override
    public List<MenuItems> getAll() {
        List<MenuItems> MenuItems = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
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
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
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
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
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
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
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
        Connection connection = JdbcUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM Menu_items WHERE id_menu=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
