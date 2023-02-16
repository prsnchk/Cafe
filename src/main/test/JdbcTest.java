import model.*;
import org.junit.Test;
import service.*;

import java.sql.SQLException;

public class JdbcTest {
    private final WaiterService waiterService = new WaiterService();
    private final PaymentTypeService paymentTypeService = new PaymentTypeService();
    private final MenuItemsService menuItemsService = new MenuItemsService();
    private final LoyaltyCardService loyaltyCardService = new LoyaltyCardService();
    private final CafeService cafeService = new CafeService();
    private final CustomerService customerService = new CustomerService();
    private final OrderService orderService = new OrderService();

    public JdbcTest() throws SQLException {
    }

    //CUSTOMER
    @Test
    public void addCustomer(){
        LoyaltyCard loyaltyCard1 = new LoyaltyCard(10, 15, "800");
        Customer customer1 = new Customer(5,"Testname","Testsurname","091234242","mail@mail.com", loyaltyCard1);
        loyaltyCardService.saveLoyaltyCard(loyaltyCard1);
        customerService.saveCustomer(customer1);
        Customer readCustomer = customerService.getCustomerById(5);
        customerService.deleteCustomer(customer1);
        loyaltyCardService.deleteLoyaltyCard(loyaltyCard1);
        assert(customer1.equals(readCustomer));
    }

    @Test
    public void updateCustomer(){
        LoyaltyCard loyaltyCard1 = new LoyaltyCard(10, 15, "800");
        Customer customer1 = new Customer(5,"Testname","Testsurname","091234242","mail@mail.com", loyaltyCard1);
        loyaltyCardService.saveLoyaltyCard(loyaltyCard1);
        customerService.saveCustomer(customer1);

        customer1.setSecondName("Testsomename");
        customer1.setPhone("+38095123123");
        customer1.setEmail("newmail@mail.com");
        customerService.updateCustomer(customer1);

        Customer readUpdatedCustomer = customerService.getCustomerById(5);
        customerService.deleteCustomer(customer1);
        loyaltyCardService.deleteLoyaltyCard(loyaltyCard1);
        //System.out.println(readUpdatedCustomer);
        //System.out.println(customer1);
        assert(customer1.equals(readUpdatedCustomer));
    }

    //CAFE
    @Test
    public void addCafe(){
        Cafe cafe1 = new Cafe(3, "DiscomfortTown");
        cafeService.saveCafe(cafe1);
        Cafe readCafe = cafeService.getCafeById(3);
        cafeService.deleteCafe(readCafe);
        System.out.println(cafe1);
        System.out.println(readCafe);
        assert(cafe1.equals(readCafe));
    }

    @Test
    public void updateCafe(){
        Cafe cafe2 = new Cafe(3, "DiscomfortTown");
        cafeService.saveCafe(cafe2);
        cafe2.setCafeName("Regeneratornaya");
        cafeService.updateCafe(cafe2);
        Cafe readCafe = cafeService.getCafeById(3);
        cafeService.deleteCafe(cafe2);
        assert(readCafe.getCafeName().equals("Regeneratornaya"));
    }

    //LOYALTY CARD
    @Test
    public void addLoyaltyCard(){
        LoyaltyCard loyaltyCard1 = new LoyaltyCard(10, 15, "800");
        loyaltyCardService.saveLoyaltyCard(loyaltyCard1);
        LoyaltyCard readMenuItems = loyaltyCardService.getLoyaltyCardById(10);
        loyaltyCardService.deleteLoyaltyCard(readMenuItems);
        assert(loyaltyCard1.equals(readMenuItems));
    }

    @Test
    public void updateLoyaltyCard(){
        LoyaltyCard loyaltyCard2 = new LoyaltyCard(10, 15, "800");
        loyaltyCardService.saveLoyaltyCard(loyaltyCard2);
        loyaltyCard2.setDiscount(20);
        loyaltyCardService.updateLoyaltyCard(loyaltyCard2);
        LoyaltyCard readLoyaltyCard = loyaltyCardService.getLoyaltyCardById(10);
        loyaltyCardService.deleteLoyaltyCard(loyaltyCard2);
        assert(readLoyaltyCard.getDiscount() == 20);
    }

    //MENU ITEMS
    @Test
    public void addMenuItems(){
        MenuItems menuItems1 = new MenuItems(10,"Страва", "Strava", 100);
        menuItemsService.saveMenuItem(menuItems1);
        MenuItems readMenuItems = menuItemsService.getMenuItemsById(10);
        menuItemsService.deleteMenuItem(readMenuItems);
        assert(menuItems1.equals(readMenuItems));
    }

    @Test
    public void updateMenuItems(){
        MenuItems menuItems2 = new MenuItems(10,"Страва", "Strava", 100);
        menuItemsService.saveMenuItem(menuItems2);
        menuItems2.setNameEng("Dish");
        menuItemsService.updateMenuItem(menuItems2);
        MenuItems readPaymentType = menuItemsService.getMenuItemsById(10);
        menuItemsService.deleteMenuItem(menuItems2);
        assert(readPaymentType.getNameEng().equals("Dish"));
    }

    //PAYMENT TYPE
    @Test
    public void addPaymentType(){
        PaymentType paymentType1 = new PaymentType(3, "ApplePay");
        paymentTypeService.savePaymentType(paymentType1);
        PaymentType readPaymentType = paymentTypeService.getPaymentTypeById(3);
        paymentTypeService.deletePaymentType(paymentType1);
        assert(paymentType1.equals(readPaymentType));
    }

    @Test
    public void updatePaymentType(){
        PaymentType paymentType2 = new PaymentType(3, "ApplePay");
        paymentTypeService.savePaymentType(paymentType2);
        paymentType2.setName("GooglePay");
        paymentTypeService.updatePaymentType(paymentType2);
        PaymentType readPaymentType = paymentTypeService.getPaymentTypeById(3);
        paymentTypeService.deletePaymentType(paymentType2);
        assert(readPaymentType.getName().equals("GooglePay"));
    }

    //WAITER
    @Test
    public void addWaiter(){
        Waiter testWaiter1 = new Waiter(10, "Eleonorochka");
        waiterService.saveWaiter(testWaiter1);
        Waiter readWaiter = waiterService.getWaiterById(10);
        waiterService.deleteWaiter(testWaiter1);
        assert(testWaiter1.equals(readWaiter));
    }

    @Test
    public void updateWaiter(){
        Waiter testWaiter2 = new Waiter(10, "Eleonorochka");
        waiterService.saveWaiter(testWaiter2);
        testWaiter2.setFirstName("Karinochka");
        waiterService.updateWaiter(testWaiter2);
        Waiter readWaiter2 = waiterService.getWaiterById(10);
        waiterService.deleteWaiter(testWaiter2);
        assert(readWaiter2.getFirstName().equals("Karinochka"));
    }

    //ORDER
    @Test
    public void addOrder(){
        Waiter waiter1 = waiterService.getWaiterById(1);
        Customer customer1 = customerService.getCustomerById(1);
        Cafe cafe1 = cafeService.getCafeById(1);
        PaymentType paymentType1 = paymentTypeService.getPaymentTypeById(1);
        MenuItems menuItem1 = menuItemsService.getMenuItemsById(1);
        MenuItems menuItem2 = menuItemsService.getMenuItemsById(2);
        MenuItems menuItem3 = menuItemsService.getMenuItemsById(3);

        Order order3 = new Order(3,100, customer1, waiter1, cafe1, paymentType1);
        order3.addMenuItem(menuItem1);
        order3.addMenuItem(menuItem2);
        order3.addMenuItem(menuItem3);

        orderService.saveOrder(order3);
        Order readOrder = orderService.getOrderId(3);
        orderService.deleteOrder(order3);
        assert(order3.equals(readOrder));
    }

    @Test
    public void updateOrder(){
        Waiter waiter1 = waiterService.getWaiterById(1);
        Customer customer1 = customerService.getCustomerById(1);
        Cafe cafe1 = cafeService.getCafeById(1);
        PaymentType paymentType1 = paymentTypeService.getPaymentTypeById(1);
        MenuItems menuItem1 = menuItemsService.getMenuItemsById(1);
        MenuItems menuItem2 = menuItemsService.getMenuItemsById(2);
        MenuItems menuItem3 = menuItemsService.getMenuItemsById(3);

        Order order3 = new Order(3,100, customer1, waiter1, cafe1, paymentType1);
        order3.addMenuItem(menuItem1);
        order3.addMenuItem(menuItem2);
        order3.addMenuItem(menuItem3);

        orderService.saveOrder(order3);
        order3.recalculatePrice();
        order3.deleteMenuItem(menuItem2);
        orderService.updateOrder(order3);

        Order readOrder = orderService.getOrderId(3);
        orderService.deleteOrder(order3);
        assert(readOrder.getPrice() == 300);
        assert(readOrder.getMenuItemsList().size() == 2);
    }
}
