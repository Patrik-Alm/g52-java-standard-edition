package se.lexicon;

import java.sql.*;

import static se.lexicon.db.MySQLConnection.getConnection;

public class JDBCDemo {
    public static void main(String[] args) {

        // Current Version - JDBC 4.3 since Java 9 (2017-09-21)

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/01_lecture_db", "root", "1234");
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM task");

            while (resultSet.next()){
                    System.out.println(
                            resultSet.getString("title") + " - " + resultSet.getString("_description")
                    );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (resultSet != null && !resultSet.isClosed()){
                    resultSet.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }
}