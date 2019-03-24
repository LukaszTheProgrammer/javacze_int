import java.util.*;
import java.util.stream.Collectors;

class Person {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .toString();
    }


    public int compareDecending(Person p2) {
        int lastNameresult= p2.lastName.compareToIgnoreCase(this.lastName);
        return lastNameresult==0 ? p2.firstName.compareToIgnoreCase(this.firstName):lastNameresult;
    }
    public int compareAscending(Person p2){
        int lastNameresult= this.lastName.compareToIgnoreCase(p2.lastName);
        return lastNameresult==0 ? this.firstName.compareToIgnoreCase(p2.firstName):lastNameresult;
    }
}

class Searching {

    public static void main(String[] args) {
        List<Person> people = Arrays
            .asList(new Person("Angela", "Lee"), new Person("Jim", "Beam"), new Person("Marty", "Sheep"),
                new Person("Zack", "Kwack"), new Person("Jimmy", "Kimmel"), new Person("Bob", "Dylan"),
                new Person("Adam", "Wong"), new Person("Bill", "DeMatheis"), new Person("Song", "Whan"),
                new Person("Henry", "Ford"), new Person("Danny", "Lorenzo"), new Person("Beatrice", "Smith"));
        Scanner scanner= new Scanner(System.in);
        while (true){
            System.out.println(">");
            String command=scanner.next();

            switch (command){
                case "list_people":
                    listPeople(people);
                    break;
                case "search":
                    String name= scanner.next();
                    search(name,people);
                    break;
                case "sort_people":
                    String order=scanner.next();
                    sort_people(order,people);
                    break;
                case "exit":
                    System.exit(0);
                    default:
                        System.out.println("Zle polecenie");
            }
        }
        // Program ma reagować na 3 komendy:
        // list_people -> wylistuje zawartość listy people
        // search <what> -> zwróci listę osób której imię bądź nazwisko zawiera wyrażenie what
        // sort_people [asc|desc] - jeśli podamy asc lista zostanie posortowana rosnąco po nazwisku,imieniu, jeśli
        //                          desc wtedy malejąco po nazwisku,imieniu
    }
    public static void listPeople(List<Person>personList){
        personList.stream().forEach(System.out::println);
    }
    public static void search(String name,List<Person>personList){
        personList.stream().filter(person ->person.getFirstName().toLowerCase().contains(name.toLowerCase())
                ||person.getLastName().toLowerCase().contains(name.toLowerCase()) )
                .forEach(System.out::println);
    }
    public static void sort_people(String order, List<Person>personList){
        if(order.equalsIgnoreCase("asc")){
            personList.stream().sorted(Person::compareAscending).forEach(System.out::println);
        }
        if (order.equalsIgnoreCase("desc")){
            personList.stream().sorted(Person::compareDecending).forEach(System.out::println);        }
        else {
            System.out.println("zly wskaznik sortowania");
        }
    }

}
