import java.util.*;

public class Warmup<T> {


    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        //napisz metodę reverse tak by dla podanej listy intów
        //zwracała listę o odwróconej kolejności.
        //czyli jeśli podamy [1,2,3,4,5] metoda zwróci [5,4,3,2,1]
        //Nie można używać Collections.reverse()
        List<Integer> revers = Reverse.reverseList(ints);
        System.out.println(revers);
        //spróbój napisać implementację tej metody bez użycia
        //jakiejkolwiek pętli (for, when, do while)
        //zmodyfikuj metodę reverse tak
        //by można ją było wywołać z listą dowolnego typu
        //na przykład:

        List<Character> chars = Arrays.asList('c', 'd', 'e', 'f');
        List<Character> reversechars = Reverse.reverseList(chars);
        System.out.println( listReverse(chars));
        System.out.println(reversechars);
    }

    public static<T> List<T> listReverse(List<T> list){
        List<T>reversList=new ArrayList<>();
        if (list.size()==0){
           return new ArrayList<>();
        }
        else {
       reversList= listReverse(list.subList(0,list.size()-1));
              reversList.add(0,list.get(list.size()-1));
              return reversList;
        }

    }

    static class Reverse<T> extends AbstractList<T> {
        private List<T> list;


        private Reverse(List<T> list) {
            this.list = new ArrayList<>(list);
        }

        public static <T> List<T> reverseList(List<T> list) {
            return new Reverse<>(list);
        }

        @Override
        public T get(int i) {
            return list.get(size() - 1 - i);
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean add(T e) {
            list.add(0, e);
            return true;
        }

        @Override
        public T set(int index, T element) {
            return list.set(size() - 1 - index, element);
        }

        @Override
        public void add(int index, T element) {
            list.add(size() - 1 - index, element);
        }

        @Override
        public T remove(int index) {
            return list.remove(size() - 1 - index);
        }
    }
}

