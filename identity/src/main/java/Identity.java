import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


class Identity {

    public static final String USERS_FILE_NAME = "./identity/src/main/resources/users.txt";
    public static Map<String, User> userDataBase = new HashMap<>();
    private static Map<String, Command> commandsByName = new HashMap<>();

    public static void main(String[] args) throws IOException {


        /*
        Napisz program który pozwoli założyć konto użytkownika
         -- add_user <email> <password>
         -- uzytkownik powinien mieć email i hasło przy pomocy których będzie mógł się zalogować
         -- email i hasło nie mogą być puste
         -- email musi być poprawnym adresem email
         -- hasło powinno mieć conajmniej 6 znaków w tym conajmniej jedną cyfrę i literę
         -- po wprowadzeniu poprawnych danych nowy uzytkownik być zapisany w pliku
         -- jeśli użytkownik z podanym mailem istnieje system nie powinien pozwolić na utworzenie 2 użytkownika
            z tym samym email'em

       Program powinien umożliwić logowanie do systemu po wprowadzeniu poprawnych danych za pomocą komendy:
         -- login <email> <hasło>
         -- udane logowanie powinno zwrócić token ( 32 znakowy hash )
         -- nieudane logowanie powinno zwrócić komunikat błędu

       Dodaj komendę ktora pozwoli zwrócić listę emaili istniejących w systemie.
         -- list_users <toke>
         -- wywołanie tej komendy powinno być możliwe tylko wtedy kiedy podamy
            token pochodzący z poprawnego logowania
         -- system nie powinien pozwalać na logowanie z niepoprawnymi tokenami

         */
        Scanner scanner = new Scanner(System.in);
        userDataBase = readUsers();
        commandsByName.put("add_user", new AddUser(userDataBase));
        commandsByName.put("login", new Login(userDataBase));
        commandsByName.put("list_users", new ListUsers(userDataBase));

        while (true) {
            System.out.println("Podaj polecenie: ");
            String polecenie = scanner.nextLine();
            try {
                List<String> tokens = Arrays.asList(polecenie.split(" "));
                if (commandsByName.containsKey(tokens.get(0))) {
                    Command command = commandsByName.get(tokens.get(0));
                    command.run(tokens.subList(1, tokens.size()));
                } else {
                    throw new RuntimeException("Nieobslugiwane polecenie");
                }

            } catch (RuntimeException ex) {
                System.out.println("Wystapil blad: " + ex.getMessage());
            }
        }
    }


    private static Map<String, User> readUsers() throws FileNotFoundException {

        File userFile = new File(USERS_FILE_NAME);
        if (userFile.exists()) {
            Scanner scanner = new Scanner(userFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    User user = mapToUser(line);
                    userDataBase.put(user.getEmail(), user);
                }
            }
            return userDataBase;
        } else {
            return new HashMap<>();
        }
    }

    private static User mapToUser(String line) {
        String[] tab = line.split(" ");

        return new User(tab[0], tab[1]);

    }


}
