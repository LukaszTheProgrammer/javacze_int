import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

class Product {

    private final String name;
    private final double priceInPln;

    public Product(String name, double priceInPln) {
        this.name = name;
        this.priceInPln = priceInPln;
    }

    public double getPriceInPln() {
        return priceInPln;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("priceInPln=" + priceInPln)
                .toString();
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
        System.out.println(premiumProducts);
    }

    private static List<Product> filterPremium(List<Product> products) {
      return   products = products.stream().filter(p -> p.getPriceInPln() > 3000).collect(Collectors.toList());


    }
    private static void task2() {



        //Napis implementacje dla każdej lambdy tak by kod się kompilował
        Function<Integer, String> itos =i->" "+i ;
        Function<List<String>, Integer> sizeOfList =List::size ;
        Function<String, Boolean> isEmpty = String::isEmpty;
        Function<Warmup, Long> getValue = w->w.value;
        Function<String, String> prefix = s->s.substring(1,3);
        Function<Integer, List<Integer>> listOf = i->Stream.of(i).collect(Collectors.toList());
    }
}