import java.util.Arrays;
import java.util.List;

public class Warmup {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        //napisz metodę reverse tak by dla podanej listy intów
        //zwracała listę o odwróconej kolejności.
        //czyli jeśli podamy [1,2,3,4,5] metoda zwróci [5,4,3,2,1]
        //Nie można używać Collections.reverse()

        //spróbój napisać implementację tej metody bez użycia
        //jakiejkolwiek pętli (for, when, do while)

        //zmodyfikuj metodę reverse tak
        //by można ją było wywołać z listą dowolnego typu
        //na przykład:
        List<Character> chars = Arrays.asList('c', 'd', 'e', 'f');
    }
}
