import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ListUsers implements Command {
    private final Map<String, User> usersDatabase;

    public ListUsers(Map<String, User> usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    @Override
    public void run(List<String> arguments) {
        validateArguments(arguments, 1);

        String token = arguments.get(0);
        String email = new String(Base64.getDecoder()
            .decode(token));

        if (usersDatabase.containsKey(email)) {
            usersDatabase.values()
                .forEach(user -> System.out.println(user.getEmail()));
        } else {
            throw new RuntimeException("Access Denied!");
        }
    }
}
