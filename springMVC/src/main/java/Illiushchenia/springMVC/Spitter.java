package Illiushchenia.springMVC;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by a.illiushchenia on 14.11.2016.
 */
public class Spitter {
    @Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
    private String fullName;
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
    private String username;
    @Size(min=6, max=20, message="The password must be at least 6 characters long.")
    private String password;
    private String email;
    private boolean updateByEmail;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }
}
