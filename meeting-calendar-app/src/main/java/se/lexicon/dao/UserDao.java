package se.lexicon.dao;

import se.lexicon.exception.AuthorizationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {

    String CREATE_USER_SQL= "";

    String FIND_BY_USERNAME_SQL = "";

    String FIND_BY_USERNAME_AND_PASSWORD = "";


    User createUser(String username);

    Optional<User> findByUserName(String username);

    boolean authenticate(User user) throws AuthorizationFailedException, UserExpiredException;

    // Add Methods for updating, remove, as needed.
}
