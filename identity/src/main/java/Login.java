import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.Base64;
import java.util.List;
import java.util.Map;

class Login implements Command {

    private Map<String, User> usersDatabase;

    public Login(Map<String, User> usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    @Override
    public void run(List<String> arguments) {
        validateArguments(arguments, 2);

        String email = arguments.get(0);
        String password = arguments.get(1);

        if (usersDatabase.containsKey(email)) {
            User user = usersDatabase.get(email);
            Argon2 argon2 = Argon2Factory.create();
            if (argon2.verify(user.getPassword(), password)) {
                String userEmail = user.getEmail();
                String token = Base64.getEncoder()
                    .encodeToString(userEmail.getBytes());

                System.out.println(token);
            } else {
                throw new RuntimeException("Niepoprawne dane do logowania");
            }

        } else {
            throw new RuntimeException("Niepoprawne dane do logowania");
        }
    }
}
