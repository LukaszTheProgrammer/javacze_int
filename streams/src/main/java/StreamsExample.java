import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {
        List<Integer> aa = Arrays.asList(1, 2, 3, 4, 5);
        aa.stream()
            .map(e -> e + 10)
            .collect(Collectors.toCollection(HashSet::new));

        aa.stream().forEach(System.out::println);
    }
}
