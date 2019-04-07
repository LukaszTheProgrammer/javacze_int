import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Span {

    private final LocalDate start;
    private final LocalDate end;

    public Span(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public boolean doesNotContain(LocalDate from, LocalDate to) {
        return to.isBefore(this.start) || from.isAfter(end);
    }
}

class Car {

    private final List<Span> spans = new ArrayList<>();
    private String name;
    private Long id;

    public Car(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", id, name);
    }

    public void rent(LocalDate from, LocalDate to) {
        spans.add(new Span(from, to));
    }

    public boolean isAvailable(LocalDate from, LocalDate to) {
        return spans.stream()
            .allMatch(s -> s.doesNotContain(from, to));
    }

    public Long getId() {
        return id;
    }
}

class CarRental {

    private static final List<Car> cars = new ArrayList<>();

    public CarRental() {
        cars.add(new Car(1L, "BMW X6"));
        cars.add(new Car(2L, "Audi A6"));
        cars.add(new Car(3L, "Mazda 6"));
        cars.add(new Car(4L, "Opel Insignia"));
        cars.add(new Car(5L, "Toyota Auris"));
    }

    public List<Car> listCars() {
        return cars;
    }

    public void rent(Long id, LocalDate from, LocalDate to) {
        Car rented = cars.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Car not found"));
        rented.rent(from, to);
    }

    public List<Car> listCars(LocalDate from, LocalDate to) {
        return cars.stream()
            .filter(c -> c.isAvailable(from, to))
            .collect(Collectors.toList());
    }
}

public class RentCarApp {

    public static void main(String[] args) {
        /*
        Napisz klasę CarRental która będzie przechowywać listę samochodów.
        Klasa powinna udostępniać następujące metody:
        - listCars - zwracającą listę samochodów

        - rentCar - pozwalającą wypożyczyć auto na pewien okres
                    metoda powinna nie pozwalać wypożyczyć auta
                    które już zostało wypożyczone

        Przeciąż metodę listCars tak by można było wyszukiwać auta
        dostępne w danym przedziale czasowym
         */

        CarRental carRental = new CarRental();
        System.out.println("All cars");
        carRental.listCars().forEach(System.out::println);
        System.out.println("");
        LocalDate from = LocalDate.of(2019, 5, 5);
        LocalDate to = LocalDate.of(2019, 5, 10);

        carRental.rent(3L, from, to);
        carRental.rent(5L, from, to);
        System.out.println("Cars available from: " + from + " to: " + to);
        carRental.listCars(from, to)
            .forEach(System.out::println);
    }
}
