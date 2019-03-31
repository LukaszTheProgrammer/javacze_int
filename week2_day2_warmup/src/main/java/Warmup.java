interface TaxCalculator {

    double calculateTax(double income);
}

class ScaleTaxCalculator implements TaxCalculator{

    private static final double TAX_FREE_AMMOUNT = 3500.00;
    private static final int TAX_THRESOLD = 85000;
    private static final double TAX_32 = 0.32;
    private static final double TAX_18 = 0.18;

    private double remainingTaxFreeAmmount = TAX_FREE_AMMOUNT;

    private double accumulatedIncome = 0;

    @Override
    public double calculateTax(double income) {
        double taxableIncome = Math.max(0, income - remainingTaxFreeAmmount);
        remainingTaxFreeAmmount = remainingTaxFreeAmmount - (income - taxableIncome);
        accumulatedIncome += taxableIncome;
        if(accumulatedIncome > TAX_THRESOLD){
            double ammountAfter85k = Math.min(accumulatedIncome - TAX_THRESOLD,
                taxableIncome) ;
            double ammountBefore85k = taxableIncome - ammountAfter85k;
            return (ammountAfter85k * TAX_32) + (ammountBefore85k * TAX_18);
        } else {
            return taxableIncome * TAX_18;
        }
    }
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

        TaxCalculator stx = new ScaleTaxCalculator();
//        System.out.println(stx.calculateTax(2500));
//        System.out.println(stx.calculateTax(2500));
        System.out.println(stx.calculateTax(50000));
        System.out.println(stx.calculateTax(50000));
        System.out.println(stx.calculateTax(50000));

    }
}
