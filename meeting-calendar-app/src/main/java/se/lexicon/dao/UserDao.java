package se.lexicon.dao;

import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {

    String CREATE_USER_SQL= "INSERT INTO users (username,_password) VALUES (?,?)";

    String FIND_BY_USERNAME_SQL = "SELECT * FROM users WHERE username = ?";

    String FIND_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE username = ? AND _password = ?";

    User createUser(String username);

    Optional<User> findByUserName(String username);

    boolean authenticate(User user) throws AuthorizationFailedException, UserExpiredException;

    // Add Methods for updating, remove, as needed.
}
