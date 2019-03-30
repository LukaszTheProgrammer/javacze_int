import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(JUnitParamsRunner.class)
public class CalculateBagFeesTest {


    @Test
    public void economyWithNoBaggageShouldHaveNoFee(){
        //given
        List<Integer>bagWeights=new ArrayList<>();
        //when
       double fees= CalculateBagFees.calculateEconomy(bagWeights);
        //then
        assertEquals(0,fees,0.00001);
    }
    @Test
    public void calculateEconnomyFeesTest() {
   //given
        List<Integer> bagList= Arrays.asList(25);

        //when
        double fees= CalculateBagFees.calculateEconomy(bagList);
        //then
        assertEquals(50,fees,0.0001);
    }
    @Test
    @Parameters({"24,7","7,24"})    public void economyTypeWith8kgOverweightSouldPayFees(int firstBagWeight, int secondBagweight){
        //given
        List<Integer>bahWeight=Arrays.asList(24,7);
        //when
        double fees = CalculateBagFees.calculateEconomy(bahWeight);
        //then
        assertEquals(200,fees,0.0001);
    }
    @Test
       public void BusinessTypeWith2SouldPayNoFees() {
        //given
        List<Integer> bagWeight = Arrays.asList(22, 22);
        //when
        double fees = CalculateBagFees.calculateBussines(bagWeight);
        //then
        assertEquals(0, fees, 0.0001);
    }
    @Test
    public void BusinessTypeWith2SouldPayFeesForOverload() {
        //given
        List<Integer> bagWeight = Arrays.asList(23, 26);
        //when
        double fees = CalculateBagFees.calculateBussines(bagWeight);
        //then
        assertEquals(75, fees, 0.0001);
    }
    @Test
    public void BusinessTypeWith3SouldPayFeesForOverload() {
        //given
        List<Integer> bagWeight = Arrays.asList(23, 26,12);
        //when
        double fees = CalculateBagFees.calculateBussines(bagWeight);
        //then
        assertEquals(375, fees, 0.0001);
    }
    @Test
    public void FirstClassTypeWith2SouldPayNoFees() {
        //given
        List<Integer> bagWeight = Arrays.asList(28, 22);
        List<Integer> bagWeith2=Arrays.asList(12,30);
        //when
        double fees = CalculateBagFees.calculateFirstClass(bagWeight);
        double fees1=CalculateBagFees.calculateFirstClass(bagWeith2);
        //then
        assertEquals(0, fees, 0.0001);
        assertEquals(0,fees1,0.0001);
    }
    @Test
    public void FirstClassTypeWith2SouldPayFees() {
        //given
        List<Integer> bagWeight = Arrays.asList(33, 22);
        List<Integer> bagWeith2=Arrays.asList(12,34);
        //when
        double fees = CalculateBagFees.calculateFirstClass(bagWeight);
        double fees1=CalculateBagFees.calculateFirstClass(bagWeith2);
        //then
        assertEquals(25, fees, 0.0001);
        assertEquals(50,fees1,0.0001);
    }
    @Test
    public void FirstClassTypeWith3SouldPayFees() {
        //given
        List<Integer> bagWeight = Arrays.asList(32, 22,12);

        //when
        double fees = CalculateBagFees.calculateFirstClass(bagWeight);

        //then
        assertEquals(300, fees, 0.0001);

    }
}