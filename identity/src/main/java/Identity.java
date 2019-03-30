import org.apache.commons.validator.routines.EmailValidator;

class Identity {

    public static void main(String[] args) {
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
    }
}
