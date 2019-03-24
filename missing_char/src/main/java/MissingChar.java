public class MissingChar {

    public static void main(String[] args) {
        System.out.println(missingChar("Hello World", 0));
        System.out.println(missingChar("Hello World", 3));
        System.out.println(missingChar("Hello World", 7));
    }

    public static String missingChar(String s, int indexOfCharToRemove) {
        return s.substring(0, indexOfCharToRemove) +
            s.substring(indexOfCharToRemove + 1);
    }
}
