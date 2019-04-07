public class Rules {
    public Rules() {
    }
    public boolean match(Cart cart, String symbol){
     return   cart.symbolsList.contains(symbol);
    }
}
