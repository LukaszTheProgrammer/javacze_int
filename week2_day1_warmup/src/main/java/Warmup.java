import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warmup {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        //napisz metodę reverse tak by dla podanej listy intów
        //zwracała listę o odwróconej kolejności.
        //czyli jeśli podamy [1,2,3,4,5] metoda zwróci [5,4,3,2,1]
        //Nie można używać Collections.reverse()
        System.out.println(reverse(ints));
        //spróbój napisać implementację tej metody bez użycia
        //jakiejkolwiek pętli (for, when, do while)

        //zmodyfikuj metodę reverse tak
        //by można ją było wywołać z listą dowolnego typu
        //na przykład:
        List<Character> chars = Arrays.asList('c', 'd', 'e', 'f');
        System.out.println(reverse(chars));
    }

    public static <T>  List<T> reverse(List<T> list) {
        if (list.size() == 0) {
            return new ArrayList<>();
        } else {
            int lastElementIndex = list.size() - 1;
            T lastElement = list.get(lastElementIndex);
            List<T> result = reverse(list.subList(0, lastElementIndex));
            result.add(0, lastElement);
            return result;
        }
    }
}
