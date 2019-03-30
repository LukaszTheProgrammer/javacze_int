import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculateBagFeesTest {

    @Test
    public void economyTypeWithNoBaggageShouldHaveNoFee() {
        //given
        List<Integer> bagWeights = new ArrayList<>();

        //when
        double fees = CalculateBagFees.calculate(TicketType.ECONOMY,
            bagWeights);

        //then
        assertEquals(0.0, fees, 0.00001);
    }

    @Test
    public void economyTypeWith1kgOverweigthShouldPayFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(24);

        //when
        double fees = CalculateBagFees.calculate(TicketType.ECONOMY,
            bagWeights);

        //then
        assertEquals(CalculateBagFees.FEE_PER_1KG, fees, 0.00001);
    }

    @Test
    @Parameters({"24,7", "7,24"})
    public void economyTypeWith8kgOverweigthShouldPayFee(
        int firstBagWeight, int secondBagWeight) {

        //given
        List<Integer> bagWeights = Arrays.asList(firstBagWeight, secondBagWeight);

        //when
        double fees = CalculateBagFees.calculate(TicketType.ECONOMY,
            bagWeights);

        double expectedFee = 8 * CalculateBagFees.FEE_PER_1KG;

        //then
        assertEquals(expectedFee, fees, 0.00001);
    }

    @Test
    public void businessTypeWith2BagsShouldPayNoFees() {
        //given
        List<Integer> bagWeights = Arrays.asList(21, 23);

        //when
        double fees = CalculateBagFees.calculate(TicketType.BUSINESS,
            bagWeights);

        //then
        assertEquals(0.0, fees, 0.00001);
    }

    @Test
    public void businessTypeWith2BagsAndOneOverweightShouldPayFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(21, 26);

        //when
        double fees = CalculateBagFees.calculate(TicketType.BUSINESS,
            bagWeights);

        int expectedOverweight = 3;
        double expectedFee = expectedOverweight * CalculateBagFees.FEE_PER_1KG;

        //then
        assertEquals(expectedFee, fees, 0.00001);
    }

    @Test
    public void firstClassWith2BagsShouldPayNoFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(29, 18);

        //when
        double fees = CalculateBagFees.calculate(TicketType.FIRST_CLASS,
            bagWeights);

        //then
        assertEquals(0.0, fees, 0.00001);
    }

    @Test
    public void firstClassWith2BagsEachOverweightWillGenerateFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(35, 25);

        //when
        double fees = CalculateBagFees.calculate(TicketType.FIRST_CLASS,
            bagWeights);
        int expectedOverweight = 5;
        double expectedFee = expectedOverweight * CalculateBagFees.FEE_PER_1KG;
        //then
        assertEquals(expectedFee, fees, 0.00001);
    }

    @Test
    public void shouldApplyBronzeDiscountTo5kgOverweightFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(35, 25);
        FrequentFlyerCard ffc = new BronzeCard();

        //when
        double fees = CalculateBagFees.calculate(TicketType.FIRST_CLASS,
            bagWeights, ffc);

        int expectedOverweight = 5;
        double fee = expectedOverweight * CalculateBagFees.FEE_PER_1KG;
        double discounted = fee / 1.1;

        //then
        assertEquals(discounted, fees, 0.00001);
    }

    @Test
    public void shouldApplySilverDiscountTo5kgOverweightFee() {
        //given
        List<Integer> bagWeights = Arrays.asList(35, 25);
        FrequentFlyerCard ffc = new SilverCard();

        //when
        double fees = CalculateBagFees.calculate(TicketType.FIRST_CLASS,
            bagWeights, ffc);

        int expectedOverweight = 5;
        double fee = expectedOverweight * CalculateBagFees.FEE_PER_1KG;
        double discounted = fee / 1.2;

        //then
        assertEquals(discounted, fees, 0.00001);
    }
}