package se.lexicon.dao.db;

import se.lexicon.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//EXAMPLE FILE - for demonstration that you can many DB connections.

public class OracleConnection {

    public static final String DB_NAME = "meeting_calendar_db";
    public static final String JDBC_URL = "jdbc:oracle://localhost:1630/" + DB_NAME;
    public static final String JDBC_USER = "appuser";
    public static final String JDBC_PASSWORD = "Appuser1234";


    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }catch ( SQLException e){
            e.printStackTrace();
            throw new DBConnectionException("Failed to Connect to DB");
        }
    }
}
