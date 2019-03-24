import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Report {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        Wczytaj zawartość pliku users.txt tworząc dla każdej lini ( z pominięciem nagłówka )
        obiekt typu User. Utworzone obiekty umieść w liście.
        Typ User powinien mieć takie pola jak sugeruje nagłówek pliku.
        Wczytaj zawartość pliku movies.txt analogicznie do users.txt tak by na końcu otrzymać
        listę obiektów typu Movie. Typ Movie powinien mieć pola jak sugeruje nagłówek pliku.
        Każdy film posiada pole author_id które odpowiada id z typu User.
        Przyporządkuj na podstawie podanych pól filmy do ich twórców.
        Wyświetl na ekranie podsumowanie w postaci nazwa użytkownika - liczba filmów
         */
        ClassLoader classLoader = Report.class.getClassLoader();
        File users = new File(classLoader.getResource("users.txt").getFile());
        Scanner scanerOfUsers = new Scanner(users);
        List<User> userList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();
        File movies = new File(classLoader.getResource("movies.txt").getFile());
        Scanner scannerOfMovies = new Scanner(movies);

        while (scanerOfUsers.hasNext()) {

            userList.add(Stream.of(scanerOfUsers.nextLine())
                    .map(s -> s.split(","))
                    .map(a -> new User(Long.parseLong(a[0].trim()), a[1], a[2], a[3]))
                    .collect(Collectors.toList()).get(0));
        }

        while (scannerOfMovies.hasNext()) {

            movieList.add( Stream.of(scannerOfMovies.nextLine())
                    .map(s -> s.split(","))
                    .map(a -> new Movie(Long.parseLong(a[0].trim()), a[1], Integer.parseInt(a[2].trim()), Long.parseLong(a[3].trim())))
                    .collect(Collectors.toList()).get(0));
        }
        Map<Long, List<Movie>> resultMap = new HashMap<>();


        for (User user : userList) {
        if(!resultMap.containsKey(user.getUserId())){
            resultMap.put(user.getUserId(),new ArrayList<>());
        }

            for (Movie movie : movieList) {

                if (movie.getAuthorId()==user.getUserId()) {
                    resultMap.get(user.getUserId()).add(movie);

                }
            }
        }


    }
}
