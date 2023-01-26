package service;

import dao.*;
import model.*;

import java.util.List;


public class JdbcTestService {

    /*
    public void testCafe(){
        CafeDaoImpl cafeDao = new CafeDaoImpl();
        cafeDao.getAllCafes();
        Cafe cafe = cafeDao.getCafeById(1);
        Cafe cafe1 = new Cafe(4, "NewCafe");
        cafeDao.saveCafe(cafe1);
        cafe1.setCafeName("NewCafe");
        cafeDao.updateCafe(cafe1);
        cafeDao.deleteCafe(cafe1);
        System.out.println(cafe.toString());
    }



    public void testOrder(){
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getAllOrders();
        Order order = orderDao.getOrderById(1);
        System.out.println(order);
        //orderDao.saveOrder(order3);
        orderDao.deleteOrder(order);
        System.out.println(order);

    }


    public void testMenuItems(){
        MenuItemsDaoImpl menuItemsDao = new MenuItemsDaoImpl();
        menuItemsDao.getAllMenuItems();
        MenuItems menuItems = menuItemsDao.getMenuItemById(1);
        MenuItems menuItems1 = new MenuItems(4, "Назва страви", "Dish Name", 15);
        menuItemsDao.saveMenuItem(menuItems1);
        menuItems1.setPrice(25);
        menuItemsDao.updateMenuItems(menuItems1);
        menuItemsDao.deleteMenuItem(menuItems1);
        System.out.println(menuItems1.toString());

    }

    public void testWaiter(){
        WaiterDaoImpl waiterDao = new WaiterDaoImpl();

        Waiter waiter1 = new Waiter(0, "Abcde");
        List<Waiter> w = waiterDao.getAllWaiters();
        System.out.println(w.size());

        //Waiter waiter = new Waiter(16, "Abc");
        //waiterDao.saveWaiter(waiter);
        //Waiter waiter1 = new Waiter(4, "Василина");
        //waiterDao.saveWaiter(waiter1);
        //System.out.println(waiter);
        //Waiter waiterread = waiterDao.getWaiterById(5);
        //System.out.println(waiterread);
        //waiterDao.saveWaiter(waiter);
        //waiterDao.deleteWaiter(waiter);
        //System.out.println(waiter);

    }

    public void testPaymentType(){
        PaymentTypeDaoImpl paymentTypeDao = new PaymentTypeDaoImpl();
        paymentTypeDao.getAllPaymentTypes();
        PaymentType paymentType = paymentTypeDao.getPaymentTypeById(2);
        System.out.println(paymentType);

    }

    public void testCard(){
        LoyaltyCardService loyaltyCardService = new LoyaltyCardService();
        LoyaltyCard newLc = loyaltyCardService.getLoyaltyCardById(987654321);
        newLc.setPointsBalance("900");
        loyaltyCardService.updateLoyaltyCard(newLc);

        LoyaltyCard newLc2 = new LoyaltyCard(5, 15, "700");
        loyaltyCardService.saveLoyaltyCard(newLc2);
        loyaltyCardService.deleteLoyaltyCard(newLc2);
    }

    public void testCustomer(){
        CustomerService customerService = new CustomerService();

        Customer dbCustomer1 = customerService.getCustomerById(1);
        System.out.println(dbCustomer1.toString());

        dbCustomer1.setEmail("newmail123@mail.gg");
        dbCustomer1.setSecondName("Newname");
        customerService.updateCustomer(dbCustomer1);

        dbCustomer1.setCustomerId(5);
        customerService.saveCustomer(dbCustomer1);
        customerService.deleteCustomer(dbCustomer1);
        System.out.println(dbCustomer1.getLoyaltyCard().getPointsBalance());
    }
     */

}
