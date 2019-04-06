import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Warmup {

    public static void main(String[] args) throws IOException {
        /*
        W katalogu resources znajduje się plik text.txt
        Wczytaj ten plik a następnie wypisz 10 najczęściej występujących słów w tym pliku.
         */

        String currentDir = System.getProperty("user.dir") + "/week3_day1_warmup/src/main/";
        Files.lines(Paths.get(currentDir + "/resources/text.txt"))
            .flatMap(line -> Arrays.stream(line.split("\\s+")))
            .map(word -> word.replaceAll("[\\W]", ""))
            .map(String::toLowerCase)
            .filter(word -> !word.isEmpty())
            .collect(Collectors.toMap(w -> w, w -> 1, (v1, v2) -> v1 + v2))
            .entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(10)
            .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));

        Map<String, Integer> s = new HashMap<>();

        Set<Entry<String, Integer>> set = s.entrySet();
        for (Entry<String, Integer> e : set) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        for (String k : s.keySet()) {
            System.out.println(s.get(k));
        }

        for(Integer v : s.values()){
            System.out.println(v);
        }
    }
}
