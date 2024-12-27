package se.lexicon.exception;

public class AuthorizationFailedException extends Exception {
    public AuthorizationFailedException(String message) {
        super(message);
    }

    public AuthorizationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
