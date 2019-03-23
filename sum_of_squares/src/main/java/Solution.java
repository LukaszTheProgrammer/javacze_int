import java.util.stream.IntStream;

public class Solution {

    public static int squaresDifference(int n) {

        int sumOfSquares = IntStream.range(1,n+1)
            .map(i -> (int) Math.pow(i,2))
            .sum();

        int sum = IntStream.range(1,n+1)
            .sum();

        int squareOfSum = (int) Math.pow(sum, 2);

        return squareOfSum - sumOfSquares;

    }
}
