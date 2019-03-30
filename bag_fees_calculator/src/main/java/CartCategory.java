public enum CartCategory {
    BRONZE("B"), SILVER("S") ,GOLD("G");

    private String symbol;

    CartCategory(String symbol) {
        this.symbol = symbol;
    }
public static CartCategory convert(String s){
        for (CartCategory c: CartCategory.values()){
            if (c.symbol.equalsIgnoreCase(s)){
                return c;
            }
        }throw new RuntimeException("Can't find category");
    }
}
