import com.fasterxml.jackson.core.JsonProcessingException;
import service.*;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";

    public  static void main(String[]args) throws SQLException, JsonProcessingException {

        WaiterService waiterService = new WaiterService();
        PaymentTypeService paymentTypeService = new PaymentTypeService();
        MenuItemsService menuItemsService = new MenuItemsService();
        LoyaltyCardService loyaltyCardService = new LoyaltyCardService();
        CafeService cafeService = new CafeService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        Connection connection = JdbcUtil.getConnection();

        //BasicConnectionPool basicConnectionPool = BasicConnectionPool.create(DB_URL,DB_USERNAME,DB_PASSWORD);
        //Connection connection = basicConnectionPool.getConnection();

        DomParserService domParserService = new DomParserService();
        domParserService.start();


       /* Waiter waiter1 = waiterService.getWaiterById(1);
        Customer customer1 = customerService.getCustomerById(1);
        MenuItems menuItems1 = menuItemsService.getMenuItemsById(1);
        LoyaltyCard loyaltyCard1 = loyaltyCardService.getLoyaltyCardById(1);
        Order order1 = orderService.getOrderId(1);

        System.out.println(waiter1);
        ObjectToJsonService objectToJsonService = new ObjectToJsonService();
        System.out.println(objectToJsonService.toJson(waiter1));
        System.out.println(objectToJsonService.toJson(customer1));
        System.out.println(objectToJsonService.toJson(menuItems1));
        System.out.println(objectToJsonService.toJson(loyaltyCard1));
        System.out.println(objectToJsonService.toJson(order1));

        */



    }
}
