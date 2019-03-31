import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class Login implements Command {
   private Map<String,User>userDataBase;

    public Login(Map<String, User> userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public void run(List<String> arguments) {
        validateArguments(arguments,2);
        String email=arguments.get(0);
        String password= arguments.get(1);
        if (userDataBase.containsKey(email)) {
            User user = userDataBase.get(email);
            Argon2 argon2 = Argon2Factory.create();
            if (argon2.verify(user.getPassword(), password)) ;
            {
                String userEmail = user.getEmail();
                String token = Base64.getEncoder()
                        .encodeToString(userEmail.getBytes());

                System.out.println(token);
            }
        } else {
            throw new RuntimeException("Niepoprawne dane do logowania");
        }
    }
}
