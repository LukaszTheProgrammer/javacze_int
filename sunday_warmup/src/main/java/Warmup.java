import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Product {

    private final String name;
    private final double priceInPln;

    public Product(String name, double priceInPln) {
        this.name = name;
        this.priceInPln = priceInPln;
    }
}

class Warmup {

    private Long value;

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        List<Product> products = Arrays.asList(new Product("Iphone", 3700.00), new Product("Dell XPS 13", 6555.00),
            new Product("LG TV 55''", 6799.00), new Product("Galaxy Tab A", 799.99),
            new Product("Huawei P8 Lite", 599.00),
            new Product("Bose Quietcomfort 35 2", 1459.99), new Product("Airpods", 699.00),
            new Product("Zenbook", 2999.99));

        List<Product> premiumProducts = filterPremium(products);
    }

    private static List<Product> filterPremium(List<Product> products) {
        //napisz implementację metody tak by zwrócona lista zawierała tylko produkty droższe niż 3000 PLN
        return products;
    }

    private static void task2() {
        //Napis implementacje dla każdej lambdy tak by kod się kompilował
        /*Function<Integer, String> itos = ;
        Function<List<String>, Integer> sizeOfList = ;
        Function<String, Boolean> isEmpty = ;
        Function<Warmup, Long> getValue = ;
        Function<String, String> prefix = ;
        Function<Integer, List<Integer>> listOf = ;*/
    }
}
