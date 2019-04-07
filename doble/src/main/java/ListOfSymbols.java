import java.util.*;

public class ListOfSymbols {
    private static EnumSet<Symbols>symbolsSet;

    private static void play(Queue<Cart>carts){
        Cart currentCart=carts.poll();
        System.out.println(currentCart);
        Cart yourCart=carts.poll();
        Rules rules= new Rules();
        Scanner scanner= new Scanner(System.in);
        String symbol= scanner.nextLine();
        while (!carts.isEmpty()){
        boolean ok= rules.match(currentCart,symbol);
        if (ok==true){
            carts.poll();
        }else {
            System.out.println("niepasujacy symbol");
            play(carts);
        }
    }}

    public static void main(String[] args) {
        Rules rules= new Rules();

        symbolsSet= EnumSet.allOf(Symbols.class);

        Cart cart1=new Cart();
        cart1.addSymbol(Symbols.IGLO,Symbols.KROPLA,Symbols.OLOWEK,Symbols.ZNAK_ZAPYTANIA,Symbols.KOTWICA,Symbols.OKO,Symbols.KOT,Symbols.JINJANG);
        Cart cart2= new Cart();
        cart2.addSymbol(Symbols.PLAMA,Symbols.NOZYCZKI,Symbols.DINOZAUR,Symbols.OLOWEK,Symbols.PIES,Symbols.PAJECZYNA,Symbols.KLUCZ,Symbols.ZAKAZ);
        Cart cart3=new Cart();
        cart3.addSymbol(Symbols.OKO,Symbols.DELFIN,Symbols.CEL,Symbols.LISC,Symbols.DOBLE,Symbols.SERCE,Symbols.SMOK,Symbols.KLUCZ);
        Cart cart4=new Cart();
        cart4.addSymbol(Symbols.KLUCZ,Symbols.KONIK,Symbols.BUTELKA,Symbols.DRZEWO,Symbols.CZASZKA,Symbols.KURCZAK,Symbols.PAJAK,Symbols.ZNAK_ZAPYTANIA);
        Cart cart5=new Cart();
        cart5.addSymbol(Symbols.PIES,Symbols.ZNAK_ZAPYTANIA,Symbols.CEL,Symbols.JABLKO,Symbols.OGIEN,Symbols.WIOLINOWY,Symbols.SWIECA,Symbols.ZEGAR);
        Queue<Cart>carts=new ArrayDeque<>();
   List<Cart>cartList= new ArrayList<>(List.of(cart1, cart2, cart3, cart4, cart5));
    Collections.shuffle(cartList);
    Collections.shuffle(cartList);
    carts.addAll(cartList);
    Cart currentCart=carts.poll();
        System.out.println(currentCart);
        while (!carts.isEmpty()){
        play(carts);

    }


    }

}
