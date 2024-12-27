package se.lexicon.dao.db;

import se.lexicon.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    public static final String DB_NAME = "meeting_calendar_db";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "1234";


    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }catch ( SQLException e){
            e.printStackTrace();
            throw new DBConnectionException("Failed to Connect to DB");
        }
    }

    //TODO - READ CREDENTIALS FROM FILE


}
