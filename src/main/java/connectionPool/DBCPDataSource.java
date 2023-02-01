package connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";
    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBCPDataSource(){ }
}
