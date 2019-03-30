import java.util.regex.Pattern;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class User {

    private final static Argon2 argon2 = Argon2Factory.create();

    private static final Pattern VALID_EMAIL_ADDRESS_PATTERN =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PASSWORD_PATTERN =
        Pattern.compile("[A-Za-z]+?[0-9]+?");

    private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = getValidatedEmail(email);
        this.password = getValidatedPassword(password);
    }

    private String getValidatedEmail(String email) {
        if (!VALID_EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            throw new RuntimeException("Invalid email");
        }
        return email;
    }

    private String getValidatedPassword(String password) {
        if (!VALID_PASSWORD_PATTERN.matcher(password).matches()) {
            throw new RuntimeException("Invalid password");
        }
        return hash(password);
    }

    private String hash(String password) {
        return argon2.hash(10, 65536, 1, password.toCharArray());
    }

    @Override
    public String toString() {
        return email + " " + password;
    }
}
