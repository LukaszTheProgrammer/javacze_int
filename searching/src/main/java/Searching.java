import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Person {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    public boolean isLike(String token) {
        String lowerCasedToken = token.toLowerCase();
        return firstName.toLowerCase().contains(lowerCasedToken) ||
            lastName.toLowerCase().contains(lowerCasedToken);
    }

    public int compareAscending(Person p2) {
        int lastNamesDifference = this.lastName.compareTo(p2.lastName);
        return lastNamesDifference == 0 ?
            this.firstName.compareTo(p2.firstName) : lastNamesDifference;
    }

    public int compareDescending(Person p2) {
        int lastNamesDifference = p2.lastName.compareTo(this.lastName);
        return lastNamesDifference == 0 ?
            p2.firstName.compareTo(this.firstName) : lastNamesDifference;
    }
}

class Searching {

    public static void main(String[] args) {
        List<Person> people = Arrays
            .asList(new Person("Angela", "Lee"), new Person("Jim", "Beam"), new Person("Marty", "Sheep"),
                new Person("Zack", "Kwack"), new Person("Jimmy", "Kimmel"), new Person("Bob", "Dylan"),
                new Person("Adam", "Wong"), new Person("Bill", "DeMatheis"), new Person("Song", "Whan"),
                new Person("Henry", "Ford"), new Person("Jack", "Smith"),
                new Person("Danny", "Lorenzo"), new Person("Beatrice", "Smith"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(">");
            String polecenie = scanner.nextLine();
            if (polecenie.equals("list_people")) {
                people.forEach(System.out::println);
            } else if (polecenie.startsWith("search")) {
                String[] tokens = polecenie.split(" ");
                people.stream()
                    .filter(person -> person.isLike(tokens[1]))
                    .forEach(System.out::println);

            } else if (polecenie.startsWith("sort_people")) {
                String[] tokens = polecenie.split(" ");
                String sortDirection = tokens[1];
                switch (sortDirection) {
                    case "asc":
                        people.stream()
                            .sorted((s1, s2) -> s1.compareAscending(s2))
                            .forEach(System.out::println);
                        break;
                    case "desc":
                        people.stream()
                            .sorted((s1, s2) -> s1.compareDescending(s2))
                            .forEach(System.out::println);
                    default:
                        System.out.println("Unknown sort direction");
                }
            } else {
                System.out.println("Nieobsługiwane polecenie!");
            }
        }
        // Program ma reagować na 3 komendy:
        // list_people -> wylistuje zawartość listy people
        // search <what> -> zwróci listę osób której imię bądź nazwisko zawiera wyrażenie what
        // sort_people [asc|desc] - jeśli podamy asc lista zostanie posortowana rosnąco po nazwisku,imieniu, jeśli
        //                          desc wtedy malejąco po nazwisku,imieniu

        // sort_people by firstname [asc|desc]
    }
}
