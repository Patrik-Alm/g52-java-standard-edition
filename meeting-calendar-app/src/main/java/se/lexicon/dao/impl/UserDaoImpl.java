package se.lexicon.dao.impl;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.db.MysqlConnection;
import se.lexicon.exception.MySQLException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;


//DAO FOR ACCESSING DATABASE
//DAO IS RESPONSIBLE FOR MANAGING DATA
// CRUD - CREATE, READ, UPDATE, DELETE

public class UserDaoImpl implements UserDao {


    @Override
    public User createUser(String username) {

        Connection connection = MysqlConnection.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(UserDao.CREATE_USER_SQL)){

            User user = new User(username);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new MySQLException("Creating user Failed, no row affected!");
            }

            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<User> findByUserName(String username) {

        Connection connection = MysqlConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME_SQL)){

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String foundUsername = resultSet.getString("username");
                String foundPassword = resultSet.getString("_password");
                boolean foundExpired = resultSet.getBoolean("is_expired");
                LocalDateTime timestampOfCreation = resultSet.getTimestamp("created_at").toLocalDateTime();

                User user = new User(foundUsername,foundPassword,foundExpired);
                System.out.println(timestampOfCreation);

                return Optional.of(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return Optional.empty();
    }

    @Override
    public boolean authenticate(User user) {
        return false;  // TODO - Implement Method
    }
}
