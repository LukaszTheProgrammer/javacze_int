import java.util.*;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Flight.class.getSimpleName() + "[", "]")
                .add("from='" + from + "'")
                .add("to='" + to + "'")
                .toString();
    }
}

class FlightSearch {

    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(new Flight("Katowice", "Londyn"), new Flight("Londyn", "Monachium"),
            new Flight("Madryt", "Mediolan"), new Flight("Katowice", "Rzym"), new Flight("Rzym", "Barcelona"),
            new Flight("Barcelona", "Madryt"), new Flight("Frankfurt", "Krakow"), new Flight("Rodos", "Paryż"),
            new Flight("Saloniki", "Barcelona"), new Flight("Dublin", "Frankfurt"), new Flight("Frankfurt", "Paryż"),
            new Flight("Warszawa", "Moskwa"), new Flight("Moskwa", "Turyn"), new Flight("Frankfurt", "Rzym"),
            new Flight("Moskwa", "Londyn"), new Flight("Warszawa", "Rzym"), new Flight("Madryt", "Warszwa"),
            new Flight("Amsterdam", "Ateny"), new Flight("Monachium", "Paryż"), new Flight("Londyn", "Paryż"),
            new Flight("Ateny", "Berno"), new Flight("Praga", "Moskwa"), new Flight("Madryt", "Warszawa"),
            new Flight("Dublin", "Praga"), new Flight("Katowice", "Amsterdam"), new Flight("Mediolan", "Ateny"),
            new Flight("Frankfurt", "Amsterdam"), new Flight("Barcelona", "Dublin"), new Flight("Turyn", "Rodos"),
            new Flight("Dublin", "Paryż"));

        Scanner scanner= new Scanner(System.in);

        while (true){
            System.out.println("Podaj komende :");
            String command=scanner.nextLine();
            String from=scanner.nextLine();
            String to=scanner.nextLine();
            switch (command){
                case "airports":
                    airports(flights);
                    break;
                case "flight":
                    flightsFromTo(from,to,flights);
                    break;
                    default:
                        System.out.println("Nie obslugiwane polaczenie");
            }
        }

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
    }

    public static void airports(List<Flight>flights){
        flights.stream().map(Flight::getFrom).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);


    }
    public static void flightsFromTo(String from,String to,List<Flight>flights){

       List<Flight>flights1= flights.stream()
                .filter(f->f.getFrom().equalsIgnoreCase(from)).collect(Collectors.toList());

    Optional<Flight>direct=flights1.stream().filter(f->f.getTo().equalsIgnoreCase(to)).findFirst();

    if (direct.isPresent()){
        System.out.println( direct.get());
    }else {



       List<List<Flight>>result= new ArrayList<>();
        for (Flight flight: flights1){
            for (Flight matchedFlights: flights){
                if(flight.getTo().equalsIgnoreCase(matchedFlights.getFrom())&&matchedFlights.getTo().equalsIgnoreCase(to)){
                    result.add(Arrays.asList(flight,matchedFlights));
                }
            }
        }
        result.forEach(flights2 -> {
            Flight f1=flights2.get(0);
            Flight f2=flights2.get(1);
            System.out.println(f1.getFrom()+ "-> "+f1.getTo()+"->"+ f2.getTo());
        });
    }




    }
}
