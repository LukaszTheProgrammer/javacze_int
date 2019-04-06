import java.util.Collections;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

enum Symbol {
    ZEBRA,
    KOSTKA,
    BUTLA,
    KOTWICA,
    KSIEZYC,
    BOMBA,
    SERCE,
    PIES,
    DELFIN,
    MLOT,
    LUDZIK,
    KLUCZ,
    OLOWEK,
    SLONCE,
    PAJAK,
    MARCHEW,
    KROPLA, SNIEZKA, DRZEWO, OKULARY, STOKROTKA;
}

class Card {

    EnumSet<Symbol> symbols;

    public Card(EnumSet<Symbol> symbols) {
        if (symbols.size() != 8) {
            throw new RuntimeException("Invalid Card");
        }
        this.symbols = symbols;
    }

    boolean matchesBySymbol(Card card2, Symbol symbol) {
        return this.symbols.contains(symbol) &&
            card2.symbols.contains(symbol);
    }

    @Override
    public String toString() {
        return symbols.stream()
            .map(Enum::name)
            .collect(Collectors.joining(", "));
    }
}

class Deque {

    Stack<Card> cards = new Stack<>();

    public Deque() {
        cards.push(new Card(EnumSet.of(Symbol.ZEBRA, Symbol.KOSTKA,
            Symbol.PIES, Symbol.SERCE, Symbol.KSIEZYC, Symbol.KOTWICA,
            Symbol.BOMBA, Symbol.BUTLA)));

        cards.push(new Card(EnumSet.of(Symbol.DELFIN, Symbol.PAJAK,
            Symbol.BOMBA, Symbol.KLUCZ, Symbol.MLOT, Symbol.SLONCE,
            Symbol.OLOWEK, Symbol.LUDZIK)));

        cards.push(new Card(EnumSet.of(Symbol.DELFIN, Symbol.MARCHEW,
            Symbol.SNIEZKA, Symbol.DRZEWO, Symbol.KROPLA, Symbol.PIES,
            Symbol.OKULARY, Symbol.STOKROTKA)));
    }

    public Card getCard() {
        return cards.pop();
    }

    public boolean hasNext() {
        return !cards.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}

public class Dobble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque deque = new Deque();
        deque.shuffle();
        System.out.println("Podaj symbol wspólny dla kart:");
        Card card1 = deque.getCard();
        long start = System.currentTimeMillis();
        play(deque, card1, scanner);
        long end = System.currentTimeMillis();
        System.out.println("Twój czas to: " + ((end - start) / 1000) + " s");
    }

    private static void play(Deque deque, Card c1, Scanner scanner) {
        if (deque.hasNext()) {
            Card c2 = deque.getCard();
            System.out.println(c1);
            System.out.println(c2);
            Symbol symbol = Symbol.valueOf(scanner.nextLine());
            boolean result2 = c2.matchesBySymbol(c1, symbol);
            while (!result2) {
                System.out.println("Nieprawidłowy symbol, spróbój jeszcze raz!");
                symbol = Symbol.valueOf(scanner.nextLine());
                result2 = c2.matchesBySymbol(c1, symbol);
            }
            System.out.println("Yep");
            play(deque, c2, scanner);
        }
    }
}
