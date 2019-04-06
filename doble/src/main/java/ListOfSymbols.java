import java.util.Arrays;
import java.util.EnumSet;

public class ListOfSymbols {
    private static EnumSet<Symbols> symbolsSet;

    public static void main(String[] args) {
        symbolsSet.addAll(Arrays.asList(Symbols.values()));
    }
}
