import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    List<Symbols> symbolsList= new ArrayList<>();

    public Cart() {

    }
    public void addSymbol(Symbols s, Symbols...ss){
        symbolsList.add(s);
        symbolsList.addAll(Arrays.asList(ss));
    }

    @Override
    public String toString() {
        return symbolsList.stream().map(symbols -> symbols.getSymbol()).collect(Collectors.joining(", "));
    }
}
