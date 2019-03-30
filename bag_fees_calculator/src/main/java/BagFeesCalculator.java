import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BagFeesCalculator {
    //Na lotnisku pracuje pani Asia
    //Przychodzą do niej ludzie z biletami na klasy
    //ekonomiczną, biznes, first class
    //pasażer z biletem na ekonomiczną może zabrać 1 walizkę do 23kg bez dopłat
    //pasażer z biletem na biznes klasę może zabrać 2 walizki do 23kg bez dopłat
    //pasażer z biletami na pierwszą klasę może zabrać 1 walizkę do 32kg i 1 do 23 bez dopłat
    //1kg ponad dozwolone kosztuje 25 zł
    //napisz metodę która na podstawie przedstawionego biletu i ilości walizek
    //obliczy opłatę za bagaż, jeśli brak opłat to metoda powinna zwracać 0
    //dodatkowo pasażer może przedstawić do biletu kartę frequent flyera
    //karty są 3 Bronze, Silver i Gold. Pierwsza daje 10% zniżki na
    // opłaty, Silver daje 20% zniżki a Gold 35%
    //uaktualnij kalkulacje tak by akceptowała karty
    public static void main(String[] args) {
        List<Integer>bagWeithList= new ArrayList<>();
        double extraFees=0;
        String continu="Y";
        Scanner scanner= new Scanner(System.in);
        System.out.println("Podaj rodzaj biletu");
       String ticket = scanner.nextLine().toLowerCase();
        System.out.println("Podaj wage bagazu:");
        addBagagge(bagWeithList);
        do {

            System.out.println("Dodac nastepny bagaz?");
             continu = scanner.nextLine();
             if (continu.equalsIgnoreCase("n")){
                 break;
             }
            System.out.println("Podaj wage: ");
             addBagagge(bagWeithList);
        }while(continu.equalsIgnoreCase("Y") );

            switch (ticket){
                case "e":
                extraFees= CalculateBagFees.calculateEconomy(bagWeithList);
                 break;
                case "b":
                   extraFees= CalculateBagFees.calculateBussines(bagWeithList);
                    break;
                case "1c":
                   extraFees= CalculateBagFees.calculateFirstClass(bagWeithList);
                    break;
                    default:
                        System.out.println("Nie obslugiwana klasa");

            }

        System.out.println("Doplata wynosi: "+extraFees);
        System.out.println("Czy klient posiada karte frequent flyer:");
        String cart= scanner.nextLine();
        if (cart.equalsIgnoreCase("y")){
            System.out.println("Podaj rodzaj karty: ");
            String cartType= scanner.nextLine();
            CartCategory category=  CartCategory.convert(cartType);
            DiscountFreqent discount = new DiscountFreqent();
            System.out.println( discount.getDiscont(category,extraFees));
            }else {
            System.out.println("Doplata wynosi: "+ extraFees);
        }
        }

    private static List<Integer> addBagagge(List<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        String weight=scanner.nextLine();
        list.add(Integer.parseInt(weight));
        return list;

    }

}
