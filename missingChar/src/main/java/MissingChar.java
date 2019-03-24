

public class MissingChar {

    public static String missingChar(String str, int n) {
      String firstPart = str.substring(0,n);
      String secondPart = str.substring(n+1);

        return firstPart+secondPart;

    }

    public static void main(String[] args) {
        System.out.println( missingChar("Kotek",2));
    }
}
