import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AddUser implements Command {

    private Map<String, User> usersDatabase;
    private String usersFilename;

    public AddUser(Map<String, User> usersDatabase, String usersFilename) {
        this.usersDatabase = usersDatabase;
        this.usersFilename = usersFilename;
    }

    @Override
    public void run(List<String> arguments) {
        validateArguments(arguments, 2);

        String email = arguments.get(0);
        String password = arguments.get(1);

        try {
            if (!usersDatabase.containsKey(email)) {
                User user = new User(email, password);
                FileWriter fileWriter = new FileWriter(usersFilename, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.println(user.toString());
                printWriter.close();
                usersDatabase.put(user.getEmail(), user);
                System.out.println("Zapisano użytkownika!");
            } else {
                throw new RuntimeException("Email zajęty: " + email);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File exception: " + ex.getMessage());
        }
    }
}
