

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.regex.Pattern;

public class User {
private static final Argon2 argon2= Argon2Factory.create();
private final String email;
    private final String password;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_PATTERN=
            Pattern.compile("[A-Za-z]+?[0-9]+?");

    public User(String email, String password) {
        this.email = getValidatetEmail(email);
        this.password = getValidatetpassword(password);
    }

    public String getPassword() {
        return password;
    }

    private String getValidatetpassword(String password) {
        if(password.startsWith("$argon")){
            return password;
        }
        if (!VALID_PASSWORD_PATTERN.matcher(password).matches()){
            throw new RuntimeException("Invalid password");
        }
        return argon2.hash(10, 65536, 1, password);
    }

    public String getEmail() {
        return email;
    }

    private String getValidatetEmail(String email) {
        if(!VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()){
         throw new RuntimeException("Invalid email");
    }
return email;
}

    @Override
    public String toString() {
        return String.format("%s %s",email,password);
    }
}
