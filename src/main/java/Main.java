import connection.BasicConnectionPool;
import service.JdbcTestService;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";

    public  static void main(String[]args) throws SQLException {
        //Connection connection = JdbcUtil.getConnection();
        //JdbcTestService jdbcTestService = new JdbcTestService();

        BasicConnectionPool basicConnectionPool = BasicConnectionPool.create(DB_URL,DB_USERNAME,DB_PASSWORD);
        Connection connection = basicConnectionPool.getConnection();

        //jdbcTestService.testCafe();
        //jdbcTestService.testWaiter();
        //jdbcTestService.testOrder();
        //jdbcTestService.testCard();
        //jdbcTestService.testCustomer();

    }
}
