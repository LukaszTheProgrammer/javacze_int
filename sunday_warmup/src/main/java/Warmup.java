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

    public double getPrice() {
        return priceInPln;
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
        //napisz implementację metody tak by zwrócona lista zawierała
        // tylko produkty droższe niż 3000 PLN
        /*List<Product> listOfPremiumProducts = new ArrayList<>();
        for(Product product : products){
            if(product.getPrice() > 3000.00){
                listOfPremiumProducts.add(product);
            }
        }*/
        return products.stream()
            .filter(p -> p.getPrice() > 3000)
            .collect(Collectors.toList());
    }

    private static void task2() {
        //Napisz implementacje dla każdej lambdy tak by kod się kompilował
        // argument -> implementacja
        //Function<R,Boolean> == Predicate<R>
        Function<Integer, String> itos = i -> "" + i;
        Function<List<String>, Integer> sizeOfList = l -> l.size();
        Function<String, Boolean> isEmpty = s -> s.isEmpty();
        Function<Warmup, Long> getValue = w -> w.value;
        Function<String, String> prefix = s -> "prefix" + s + "_";
        Function<Integer, List<Integer>> listOf = i -> {
            return IntStream.range(1, i + 1)
                .boxed()
                .collect(Collectors.toList());
        };

        Arrays.asList(1, 2, 3, 4).stream() // produces list of 4 ints [1,2,3,4]
            .map(i -> itos.apply(i))
            .map(s -> prefix.apply(s))
            .forEach(i -> System.out.println(i));
    }
}
