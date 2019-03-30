import java.util.Comparator;
import java.util.List;

public class CalculateBagFees {
    private static final double ECONOMY_MAX_WEIGHT = 23;
    private static final double FIRST_CLASS_MAX_WEIGHT = 32;
    private static final double EXTRA_FEES = 25;

    public static double calculateEconomy( List<Integer> bagWeight) {
        Allowence allowence = new Allowence();
        return bagWeight.stream()
                .sorted(Comparator.reverseOrder())
                .map(weight -> weight - allowence.getAllowance())
                .filter(difference -> difference > 0)
                .map(d -> d * EXTRA_FEES)
                .reduce(0.0, (acc, elem) -> acc += elem);


    }
    public static double calculateBussines(List<Integer>bagWeight){
        if(bagWeight.size()<=2){
            int overload=0;
            for (Integer weight:bagWeight){
                if (weight>ECONOMY_MAX_WEIGHT){
                    overload+=weight-ECONOMY_MAX_WEIGHT;
                }
            }return overload*EXTRA_FEES;
        }else {
            int overload=0;
           if( bagWeight.get(0)>ECONOMY_MAX_WEIGHT){
             overload+=  bagWeight.get(0)-ECONOMY_MAX_WEIGHT;
           }
           if (bagWeight.get(1)>ECONOMY_MAX_WEIGHT){
               overload+=bagWeight.get(1)-ECONOMY_MAX_WEIGHT;
           }
            for (int i = 2; i <bagWeight.size() ; i++) {
                overload+=bagWeight.get(i);

            }return overload*EXTRA_FEES;
        }
    }
    public static double calculateFirstClass(List<Integer>bagWeight){
        bagWeight.sort(Comparator.reverseOrder());
        if(bagWeight.size()<=2){
            int overload=0;
            if(bagWeight.get(0)>FIRST_CLASS_MAX_WEIGHT){
                overload+=bagWeight.get(0)-FIRST_CLASS_MAX_WEIGHT;
            }
            if (bagWeight.get(1)>ECONOMY_MAX_WEIGHT){
                overload+=bagWeight.get(1)-ECONOMY_MAX_WEIGHT;
            }


            return overload*EXTRA_FEES;
        }else {
            int overload=0;
            if( bagWeight.get(0)>FIRST_CLASS_MAX_WEIGHT){
                overload+=  bagWeight.get(0)-FIRST_CLASS_MAX_WEIGHT;
            }
            if (bagWeight.get(1)>ECONOMY_MAX_WEIGHT){
                overload+=bagWeight.get(1)-ECONOMY_MAX_WEIGHT;
            }
            for (int i = 2; i <bagWeight.size() ; i++) {
                overload+=bagWeight.get(i);

            }return overload*EXTRA_FEES;
        }
    }




    private static class Allowence {
        int allowance = 23;

        int getAllowance() {
            int currentAllowence = allowance;
            if (allowance > 0) {
                allowance -= 23;
            }
            return currentAllowence;
        }
    }
}

