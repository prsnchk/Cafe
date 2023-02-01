package service;

import jdbc.MenuItemsDaoImpl;

import model.MenuItems;

import java.util.List;

public class MenuItemsService {
    MenuItemsDaoImpl menuItemsDao = new MenuItemsDaoImpl();

    public List<MenuItems> getAllLoyaltyCards(){
        return menuItemsDao.getAll();
    }

    public MenuItems getMenuItemsById(int id){
        return menuItemsDao.getEntityById(id);
    }

    public void updateMenuItem(MenuItems m){
        menuItemsDao.update(m);
    }

    public void saveMenuItem(MenuItems m){
        menuItemsDao.save(m);
    }

    public void deleteMenuItem(MenuItems m){
        menuItemsDao.delete(m.getMenuId());
    }
}
