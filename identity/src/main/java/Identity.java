import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class Identity {

    private static final String USERS_FILENAME = "/Users/lukasz/users.txt";
    private static Map<String, User> usersDatabase = new HashMap<>();
    private static Map<String, Command> commandsByName = new HashMap<>();


    public static void main(String[] args) throws IOException {
        usersDatabase = readUsers();
        commandsByName.put("add_user", new AddUser(usersDatabase, USERS_FILENAME));
        commandsByName.put("login", new Login(usersDatabase));
        commandsByName.put("list_users", new ListUsers(usersDatabase));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Proszę podać komendę:");
            String polecenie = scanner.nextLine();
            try {
                List<String> tokens = Arrays.asList(polecenie.split(" "));
                if (commandsByName.containsKey(tokens.get(0))) {
                    Command command = commandsByName.get(tokens.get(0));
                    command.run(tokens.subList(1, tokens.size()));
                } else {
                    throw new RuntimeException("Nieobsługiwane polecenie");
                }
            } catch (RuntimeException ex) {
                System.out.println("Wystąpił błąd: " + ex.getMessage());
            }
        }
    }

    private static Map<String, User> readUsers() throws FileNotFoundException {
        File userFile = new File(USERS_FILENAME);
        if (userFile.exists()) {
            Scanner scanner = new Scanner(userFile);
            Map<String, User> result = new HashMap<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    User user = mapToUser(line);
                    result.put(user.getEmail(), user);
                }
            }
            return result;
        } else {
            return new HashMap<>();
        }
    }

    private static User mapToUser(String line) {
        String[] tokens = line.split(" ");

        return new User(tokens[0], tokens[1]);
    }
}
