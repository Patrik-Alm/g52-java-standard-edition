package se.lexicon.model;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/*
Constructors
username, password, expired
username, password - Non-active
username - Generate Password, Non-active
 */
public class User {
    private String username;
    private String password;
    private boolean expired;

    public User(String username, String password, boolean expired) {
        this.setUsername(username);
        this.password = password;
        this.expired = expired;
    }

    public User(String username, String password) {
        this.setUsername(username);
        this.password = password;
        this.expired = false;
    }

    public User(String username) {
        this.setUsername(username);
        this.password = this.generateRandomPassword();
        this.expired = false;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("username should not be null or empty.");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    protected void newPassword() {
        this.password = this.generateRandomPassword();
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    private String generateRandomPasswordUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 15);
        // 0123457689ABCDEF - HEXADECIMAL
    }

    private String generateRandomPassword(){
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 10;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public String userInfo() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User Info: ").append('\n');
        sb.append("username: ").append(username).append('\n');
        sb.append("password: ").append(password).append('\n'); // TODO - HIDE?
        sb.append("expired: ").append(expired).append('\n');
        return sb.toString();
    }
}
