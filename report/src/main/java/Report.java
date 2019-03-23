/*
        Wczytaj zawartość pliku users.txt tworząc dla każdej lini
        ( z pominięciem nagłówka )
        obiekt typu User. Utworzone obiekty umieść w liście.
        Typ User powinien mieć takie pola jak sugeruje nagłówek pliku.
        Wczytaj zawartość pliku movies.txt analogicznie do users.txt tak
        by na końcu otrzymać
        listę obiektów typu Movie. Typ Movie powinien mieć pola jak
        sugeruje nagłówek pliku.
        Każdy film posiada pole author_id które odpowiada id z typu User.
        Przyporządkuj na podstawie podanych pól filmy do ich twórców.
        Wyświetl na ekranie podsumowanie
        w postaci nazwa użytkownika - liczba filmów
         */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Report {

    public static void main(String[] args) throws FileNotFoundException {
        /*List<Movie> movies = readFileLines("movies.txt").stream()
            .skip(1)
            .map(line -> line.split(","))
            .map(listaNapisow -> getMovie(listaNapisow))
            .collect(Collectors.toList());*/

        List<String> fileLines = readFileLines("movies.txt");
        List<Movie> movies2 = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); ++i) {
            String[] napisy = fileLines.get(i).split(",");
            Movie movie = getMovie(napisy);
            movies2.add(movie);
        }

        movies2.forEach(movie -> System.out.println(movie));

        List<String> userFileLines = readFileLines("users.txt");
        List<User> users = new ArrayList<>();
        for (int i = 1; i < userFileLines.size(); ++i) {
            String[] napisy = userFileLines.get(i).split(",");
            User user = getUser(napisy);
            users.add(user);
        }

        users.forEach(user -> System.out.println(user));
    }

    private static User getUser(String[] napisy) {
        long id = Long.parseLong(napisy[0].trim());
        String firstName = napisy[1];
        String lastName = napisy[2];
        String email = napisy[3];

        return new User(id, firstName, lastName, email);
    }

    private static Movie getMovie(String[] listaNapisow) {
        long id = Long.parseLong(listaNapisow[0].trim());
        String title = listaNapisow[1].trim();
        int length = Integer.parseInt(listaNapisow[2].trim());
        long authorId = Long.parseLong(listaNapisow[3].trim());

        return new Movie(id, title, length, authorId);
    }

    private static List<String> readFileLines(String filename) throws FileNotFoundException {
        List<String> fileLines = new ArrayList<>();
        File plik = new File("/Users/lukasz/projects/javacze_int/report/src/main/resources/" + filename);
        Scanner scanner = new Scanner(plik);

        while (scanner.hasNext()) {
            fileLines.add(scanner.nextLine());
        }
        return fileLines;
    }
}
