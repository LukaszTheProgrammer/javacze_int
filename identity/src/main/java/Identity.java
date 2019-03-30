import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Identity {

    /*
        Napisz program który pozwoli założyć konto użytkownika
         -- add_user <email> <password>
         -- uzytkownik powinien mieć email i hasło przy pomocy których będzie
            mógł się zalogować
         -- email i hasło nie mogą być puste
         -- email musi być poprawnym adresem email
         -- hasło powinno mieć conajmniej 6 znaków w tym conajmniej jedną cyfrę
            i literę
         -- po wprowadzeniu poprawnych danych nowy uzytkownik być zapisany
            w pliku
         -- jeśli użytkownik z podanym mailem istnieje system nie powinien
            pozwolić na utworzenie 2 użytkownika z tym samym email'em

       Program powinien umożliwić logowanie do systemu po wprowadzeniu
       poprawnych danych za pomocą komendy:
         -- login <email> <hasło>
         -- udane logowanie powinno zwrócić token ( 32 znakowy hash )
         -- nieudane logowanie powinno zwrócić komunikat błędu

       Dodaj komendę ktora pozwoli zwrócić listę emaili istniejących w systemie.
         -- list_users <toke>
         -- wywołanie tej komendy powinno być możliwe tylko wtedy kiedy podamy
            token pochodzący z poprawnego logowania
         -- system nie powinien pozwalać na logowanie z niepoprawnymi tokenami

         */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Proszę podać komendę:");
            String polecenie = scanner.nextLine();
            List<String> tokens = Arrays.asList(polecenie.split(" "));
            if (tokens.size() == 3) {
                try {
                    if (tokens.get(0).equals("add_user")) {
                        addUser(tokens.get(1), tokens.get(2));
                    } else {
                        System.out.println("Nieznane polecenie: " + polecenie);
                    }
                } catch (RuntimeException ex) {
                    System.out.println("Wystąpił błąd: " + ex.getMessage());
                }
            } else {
                System.out.println("Niepoprawne polecenie: " + polecenie);
            }
        }
    }

    private static void addUser(String email, String password) throws IOException {
        User user = new User(email, password);
        String filePath = "/Users/lukasz/users.txt";
        FileWriter fileWriter = new FileWriter(filePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.write(user.toString() + "\n\r");
        printWriter.close();
        System.out.println("Zapisano użytkownika!");
    }
}
