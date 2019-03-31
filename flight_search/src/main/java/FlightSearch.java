import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flight {

    private final String from;
    private final String to;
    private final List<String> connections;

    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
        this.connections = Collections.emptyList();
    }

    public Flight(String from, List<String> connections, String to) {
        this.from = from;
        this.to = to;
        this.connections = connections;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public List<String> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        String c = connections.stream()
            .collect(Collectors.joining("->"));
        String b = c.isEmpty() ? "->" : "->" + c + "->";
        return from + b + to;
    }

    public boolean isTo(String destination) {
        return this.to.equals(destination);
    }
}

class FlightSearch {

    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(new Flight("Katowice", "Londyn"),
            new Flight("Londyn", "Monachium"),
            new Flight("Madryt", "Mediolan"), new Flight("Katowice", "Rzym"),
            new Flight("Rzym", "Barcelona"),
            new Flight("Barcelona", "Madryt"), new Flight("Frankfurt", "Krakow"),
            new Flight("Rodos", "Paryż"),
            new Flight("Saloniki", "Barcelona"), new Flight("Dublin", "Frankfurt"),
            new Flight("Frankfurt", "Paryż"),
            new Flight("Warszawa", "Moskwa"), new Flight("Moskwa", "Turyn"),
            new Flight("Frankfurt", "Rzym"),
            new Flight("Moskwa", "Londyn"), new Flight("Warszawa", "Rzym"),
            new Flight("Madryt", "Warszwa"),
            new Flight("Amsterdam", "Ateny"), new Flight("Monachium", "Paryż"), new Flight("Londyn", "Paryż"),
            new Flight("Ateny", "Berno"), new Flight("Praga", "Moskwa"), new Flight("Madryt", "Warszawa"),
            new Flight("Dublin", "Praga"), new Flight("Katowice", "Amsterdam"), new Flight("Mediolan", "Ateny"),
            new Flight("Frankfurt", "Amsterdam"), new Flight("Barcelona", "Dublin"), new Flight("Turyn", "Rodos"),
            new Flight("Dublin", "Paryż"));

        // Dla podanej powyżej listy lotów napisz program, który obsłuzy następujące komendy:
        // airports - zwróci listę unikalnych lotnisk z których są loty
        // flight <from> <to> - zwróci listę dostępnych połączeń z miasta podanego jako parametr <from> do miast <to>
        //                      jeśli z miasta docelowego nie ma bezpośredniego połączenia a są loty przesiadkowe to
        //                      powinniśmy dostać listę wszystkich lotów pośrednich
        //                      na przykład `flight Katowice Barcelona` powinniśmy dostać <Katowice> -> <Rzym> -> <Barcelona>
        // jeśli możliwe jest więcej połączeń należy wydrukować wszystkie które spełniają kryterium

        // DODATKOWO! zmodyfikuj program tak by polecenie flight <from> zwróciło wszystkie możliwe loty z danego lotniska
        // DODATKOWO! postaraj się do lotu dodać datę wylotu i wzbogać wyszukiwanie tak by brał pod uwagę daty i nie zwracał
        // lotów które są po zadanej dacie

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(">");
            String command = scanner.nextLine();
            if (command.equals("airports")) {
                listAvailableAirports(flights);
            } else if (command.startsWith("flight")) {
                String[] parsedCommand = command.split(" ");
                if (parsedCommand.length == 3) {
                    List<Flight> result = findFlight(flights, parsedCommand[1], parsedCommand[2]);
                    if (result.size() == 0) {
                        System.out.println("Nie znaleziono lotów spełniających kryterium");
                    } else {
                        result.forEach(System.out::println);
                    }
                }

            } else {
                System.out.println("Nieobsługiwany lot");
            }
        }
    }

    private static List<Flight> findFlight(List<Flight> flights,
                                           String departure, String destination) {

        Map<Boolean, List<Flight>> flighsByMatchingDeparture = flights.stream()
            .collect(Collectors.partitioningBy(f -> f.getFrom().equals(departure)));

        List<Flight> flightsFromDeparture = flighsByMatchingDeparture.get(true);
        List<Flight> restOfFlights = flighsByMatchingDeparture.get(false);

        List<Flight> matching = flightsFromDeparture.stream()
            .filter(f -> f.isTo(destination))
            .collect(Collectors.toList());

        List<Flight> connectingFlights = flightsFromDeparture.stream()
            .filter(f -> !f.isTo(destination))
            .flatMap(f -> findFlight(restOfFlights, f.getTo(), destination).stream()
                .map(pp -> makeConnection(f, pp)))
            .collect(Collectors.toList());

        return Stream.concat(matching.stream(), connectingFlights.stream())
            .collect(Collectors.toList());
    }

    private static Flight makeConnection(Flight f1, Flight f2) {
        List<String> connections = new ArrayList<>(f2.getConnections());
        connections.add(0, f1.getTo());
        return new Flight(f1.getFrom(), connections, f2.getTo());
    }

    private static void listAvailableAirports(List<Flight> flights) {
        flights.stream()
            .map(f -> f.getFrom())
            .collect(Collectors.toCollection(TreeSet::new))
            .forEach(airport -> System.out.println(airport));
    }
}
