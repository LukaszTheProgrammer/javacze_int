interface TaxCalculator {

    int calculateTax(double income);
}

public class Warmup {

    public static void main(String[] args) {
        //dany jest interfejs TaxCalculator
        //z jedną metodą calculateTax
        //napisz 2 implementacje.
        //jedna będzie liczyć podatki dla
        //zadanych dochodów w sposób liniowy
        //z oprocentowaniem stałym 19%
        //druga policzy w skali 18% do 85K PLN
        //32% z kwoty powyżej 85K PLN z zachowaniem
        //kwoty wolnej od podatku 3500 PLN

        //przykład dla skali:
        //calculateTax(50000); -> 8370
        //calculateTax(50000); -> 6930 + 2070 = 9000
        //calculateTax(50000); -> 16000

        //przykład dla liniowego
        //calculateTax(50000) -> 9500
        //calculateTax(50000) -> 9500
        //calculateTax(50000) -> 9500

    }
}
