public class StackRunner {

    public static void main(String[] args) {
        /*
        Napisz klasę Stack.
        Klasa powinna mieć konstruktor umożliwiający zainicjowanie
        jej z dowolną listą elementów np.:
        Stack s = new Stack(10, 12, 15);
        lub
        Stack s = new Stack(4, 6, 10, 30, 20);
        Klasa powinna mieć 3 metody isEmpty() zwracająca boolean
        jeśli stos jest pusty, metodę add przyjmującą element który
        zostanie dodany na wierzch stosu.
        Klasę pop() zwracającą pierwszy element z wierzchu stosu lub rzucającą
        wyjątek jeśli stos jet pusty.
        Następnie utwórz stos z 10 elementami i wypisz jego zawartość na ekranie
         */

       Stack s=new Stack("Ja","SE","FS");

        System.out.println(s.isEmpty());

    }
}
