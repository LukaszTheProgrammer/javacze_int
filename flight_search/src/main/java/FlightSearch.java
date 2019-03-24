import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Flight {

    private final String from;
    private final String to;

    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
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
                    findFlight(flights, parsedCommand[1], parsedCommand[2]);
                }

            } else {
                System.out.println("Nieobsługiwany lot");
            }
        }
    }

    private static void findFlight(List<Flight> flights,
                                   String from, String to) {
        List<Flight> flightsFromGivenDeparture = flights.stream()
            .filter(flight -> flight.getFrom().equals(from))
            .collect(Collectors.toList());

        Optional<Flight> matchingFlight = flightsFromGivenDeparture.stream()
            .filter(flight -> flight.getTo().equals(to))
            .findFirst();

        if (matchingFlight.isPresent()) {
            Flight flight = matchingFlight.get();
            System.out.println(flight.getFrom() + " " + flight.getTo());
        } else {
            List<List<Flight>> result = new ArrayList<>();
            for (Flight flight : flightsFromGivenDeparture) {
                for (Flight flight2 : flights) {
                    if (flight.getTo().equals(flight2.getFrom()) &&
                        flight2.getTo().equals(to)) {
                        result.add(Arrays.asList(flight, flight2));
                    }
                }
            }

            result.forEach(f -> {
                    Flight f1 = f.get(0);
                    Flight f2 = f.get(1);
                    System.out.println(f1.getFrom() + " -> " + f1.getTo() + " ->" + f2.getTo());
                }
            );

        }

    }

    private static void listAvailableAirports(List<Flight> flights) {
        flights.stream()
            .map(f -> f.getFrom())
            .collect(Collectors.toCollection(TreeSet::new))
            .forEach(airport -> System.out.println(airport));
    }
}
