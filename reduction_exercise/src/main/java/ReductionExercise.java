import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}

public class ReductionExercise {

    public static void main(String[] args) {
        Stream.of("Ala", "Natalia", "Basia", "Wiola")
            .reduce("", (a, e) -> a + " " + e);

        //BiFunction<String,String,String> bireductor = (a, e) -> a + " " + e;
        //bireductor.apply("", "Ala") -> " Ala"
        //bireductor.apply(" Ala ", "Natalia") -> " Ala Natalia"
        //bireductor.apply(" Ala Natalia", "Basia") -> " Ala Natalia Basia"
        //bireductor.apply(" Ala Natalia Basia", "Wiola") -> " Ala Natalia Basia Wiola"

        // "Ala Natalia Basia Wiola"

        List<Product> products = Arrays.asList(
            new Product("Iphone", 3799.00), new Product("Galaxy S10", 3500.00),
            new Product("Dell XPS", 6700.00), new Product("Huawei P10", 4300.00),
            new Product("Acer Aspire", 2999.00)

        );

        double productsPriceSum = products.stream()
            .map(p -> p.getPrice())
            .reduce(0.0, (acc, e) -> acc + e);

        System.out.println("Cena wszystkich produktów to:" + productsPriceSum);

        double highestPrice = products.stream()
            .map(p -> p.getPrice())
            .reduce(Double.MIN_VALUE, (acc, e) -> Math.max(acc, e));

        System.out.println("Najdroższy produkt kosztuje: " + highestPrice);

        double priceMultiplication = products.stream()
            .map(p -> p.getPrice())
            .reduce(1.0, (acc, e) -> acc * e);

        double maxTemp = Stream.of(-10, -5, -1)
            .reduce(Integer.MIN_VALUE, (acc, e) -> Math.max(acc, e));


    }
}
