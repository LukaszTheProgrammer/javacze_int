import java.util.StringJoiner;
import java.util.stream.Stream;

public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;

    public User(long userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
