import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AddUser implements Command {
    private static final String USERS_FILE_NAME = "./identity/src/main/resources/users.txt";
    private Map<String, User> userDataBase;

    public AddUser(Map<String, User> userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public void run(List<String> arguments) {
       validateArguments(arguments,2);
        String email = arguments.get(0);
        String password = arguments.get(1);
        try {

            if (!userDataBase.containsKey(email)) {
                User user = new User(email, password);
                System.out.println("User successfully created");
                FileWriter fileWriter = new FileWriter(USERS_FILE_NAME, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.write(user.toString() + "\n");
                printWriter.close();
                userDataBase.put(email, user);

                //   System.out.println("User successfully writed");
            } else {
                throw new RuntimeException(" Email zajety :" + email);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File exception: " + ex.getMessage());
        }
    }
}

