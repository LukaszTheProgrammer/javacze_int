import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CalculateBagFees {

    public final static double FEE_PER_1KG = 25.0;

    public static double calculate(TicketType ticketType,
                                   List<Integer> bagWeights) {

        Allowance allowance = getAllowance(ticketType);

        return bagWeights.stream()
            .sorted(Comparator.reverseOrder())
            .map(weight -> weight - allowance.getAllowance())
            .filter(difference -> difference > 0)
            .map(d -> d * FEE_PER_1KG)
            .reduce(0.0, (acc, elem) -> acc += elem);
    }

    private static Allowance getAllowance(TicketType ticketType) {
        switch (ticketType) {
            case ECONOMY:
                return new Allowance(Arrays.asList(23));
            case BUSINESS:
                return new Allowance(Arrays.asList(23, 23));
            case FIRST_CLASS:
                return new Allowance(Arrays.asList(32, 23));
            default:
                throw new RuntimeException("Unhandled TicketType");
        }
    }

    public static double calculate(TicketType ticketType,
                                   List<Integer> bagWeights,
                                   FrequentFlyerCard ffc) {
        double discount = ffc.getDiscountRate() / 100.0;
        double fee = calculate(ticketType, bagWeights);
        return fee / (1 + discount);
    }

    private static class Allowance {

        List<Integer> allowance;

        Allowance(List<Integer> allowance) {
            this.allowance = allowance;
        }

        int getAllowance() {
            if (allowance.size() > 0) {
                Integer currentAllowance = allowance.get(0);
                allowance = allowance.subList(1, allowance.size());
                return currentAllowance;
            }
            return 0;
        }
    }
}
