package connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPDataSource {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        Properties properties = new Properties();
        String filename = "src/main/resources/db.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error loading config for DB!");
            throw new RuntimeException(e);
        }
        ds.setUrl(properties.getProperty("db_url"));
        ds.setUsername(properties.getProperty("db_username"));
        ds.setPassword(properties.getProperty("db_password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBCPDataSource(){ }
}
