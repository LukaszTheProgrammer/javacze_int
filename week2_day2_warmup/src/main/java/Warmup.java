interface TaxCalculator {

    double calculateTax(double income);
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
        LineTax lineTax = new LineTax();
        NoLineTax noLineTax = new NoLineTax();

        System.out.println(lineTax.calculateTax(100000));
        System.out.println(noLineTax.calculateTax(50000));
        System.out.println(noLineTax.calculateTax(50000));
        System.out.println(noLineTax.calculateTax(30000));
        System.out.println(noLineTax.calculateTax(50000));

    }

    public static class LineTax implements TaxCalculator {

        @Override
        public double calculateTax(double income) {
            return income * 0.19;
        }
    }

    public static class NoLineTax implements TaxCalculator {
        private final double TAX_18PERCENT_LIMIT = 88500;
        private double incomes;
        private double check;
        private double freeOfTaxAmond = 3500;
        private boolean isOver1time = false;

        @Override
        public double calculateTax(double income) {
            incomes += income;

            if (incomes > TAX_18PERCENT_LIMIT && !isOver1time) {

                double p = Math.max(0, TAX_18PERCENT_LIMIT - income);
                check = (p) * 0.18;
                double tax = (income - p) * 0.32;
                isOver1time = true;
                return tax + check;
            } else if (incomes > TAX_18PERCENT_LIMIT && isOver1time) {
                return income * 0.32;
            } else {
                double taxableIncome = Math.max(0, income - freeOfTaxAmond);

                freeOfTaxAmond = freeOfTaxAmond - (income - taxableIncome);

                return taxableIncome * 0.18;
            }

        }
    }
}
