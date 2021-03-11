package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotNull(message = "Field required")
    @NotBlank(message = "Field required")
    @Size(min = 5, max = 15, message = "Must be between 5 and 15 characters")
    private String username;

    @Email(message = "Invalid input")
    @NotNull(message = "Should not be null")
    private String email;

    @NotNull(message = "Field required")
    @Size(min = 6, message = "Must be at least 6 characters")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() { }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() { return verifyPassword; }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (this.password != null && this.verifyPassword != null) {
            if (!this.password.equals(this.verifyPassword)) {
                this.verifyPassword = null;
            }
        }
    }

}
