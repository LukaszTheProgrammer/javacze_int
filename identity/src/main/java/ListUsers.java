import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ListUsers implements Command {
 private Map<String,User>userDataBase;

    public ListUsers(Map<String, User> userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public void run(List<String> arguments) {
    validateArguments(arguments,1);

        String email = new String(Base64.getDecoder().decode(arguments.get(0)));

        if (userDataBase.containsKey(email)) {
            userDataBase.values().forEach(user -> System.out.println(user.getEmail()));
        } else {
            throw new RuntimeException("Access Denied!");
        }
    }
}
