import java.util.Arrays;
import java.util.List;

class Person {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Searching {

    public static void main(String[] args) {
        List<Person> people = Arrays
            .asList(new Person("Angela", "Lee"), new Person("Jim", "Beam"), new Person("Marty", "Sheep"),
                new Person("Zack", "Kwack"), new Person("Jimmy", "Kimmel"), new Person("Bob", "Dylan"),
                new Person("Adam", "Wong"), new Person("Bill", "DeMatheis"), new Person("Song", "Whan"),
                new Person("Henry", "Ford"), new Person("Danny", "Lorenzo"), new Person("Beatrice", "Smith"));

        // Program ma reagować na 3 komendy:
        // list_people -> wylistuje zawartość listy people
        // search <what> -> zwróci listę osób której imię bądź nazwisko zawiera wyrażenie what
        // sort_people [asc|desc] - jeśli podamy asc lista zostanie posortowana rosnąco po nazwisku,imieniu, jeśli
        //                          desc wtedy malejąco po nazwisku,imieniu
    }
}
