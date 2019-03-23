import java.util.HashMap;
import java.util.Map;

interface Command {

    void execute();
}

class Commands {

    public static void main(String[] args) {
        Map<String, Command> commandsByNames = new HashMap<>();

        //Napisz kilka implementacji interfejsu Command a następnie pobieraj od użytkownika
        //komendy jeśli jest taka komenda wykonaj ją jeśli nie ma wyświetl komunikat o nieobsługiwanej
        //komendzie. Przykładowe komendy time -> wyświetla godzinę, date -> wyświetla datę, random - wyświetla losową liczbę
    }
}
