package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
        //Підключення до бази даних MySql за допомогою драйвера JDBC
        private static final String DB_DRIVER =
                "com.mysql.cj.jdbc.Driver";
        private static final String DB_URL =
                "jdbc:mysql://localhost:3306/cafe";
        private static final String DB_USERNAME = "root";
        private static final String DB_PASSWORD = "1234";

        public static Connection getConnection(){
            Connection conn = null;
            try{
                //Реєстрація драйвера JDBC
                Class.forName(DB_DRIVER);

                //Відкриття з'єднання
                conn = DriverManager.
                        getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                if(conn != null){
                    System.out.println("Successfully connected.");
                }else{
                    System.out.println("Failed to connect.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return conn;
        }
    }

