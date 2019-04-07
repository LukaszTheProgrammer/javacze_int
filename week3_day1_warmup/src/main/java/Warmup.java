import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class Warmup {
    public static final String FILE_PATCH = "./week3_day1_warmup/src/main/resources/text.txt";
    public static List<String> textFile = new ArrayList<>();
    public static Map<String, Integer> count = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        /*
        W katalogu resources znajduje się plik text.txt
        Wczytaj ten plik a następnie wypisz 10 najczęściej występujących słów w tym pliku.
         */
        File file_source = new File(FILE_PATCH);
        if (file_source.exists()) {
            Scanner scanner = new Scanner(file_source);
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().trim().split("\\s");
                for (String word : line) {
                    textFile.add(word);
                }
            }
        }
        textFile = textFile.stream().map(String::toLowerCase)
                .map(s -> s.replaceAll("[^A-Za-z]", ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        for (String word : textFile) {
            if (!count.containsKey(word)) {
                count.put(word, 1);

            } else count.replace(word, count.get(word) + 1);
        }
        count.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));

    }

}



