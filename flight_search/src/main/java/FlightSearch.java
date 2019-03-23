import java.util.Arrays;
import java.util.List;

class Flight {

    private final String from;
    private final String to;

    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
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
}
