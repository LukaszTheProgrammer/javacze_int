public class DiscountFreqent implements Discount {

    @Override
    public double getDiscont(CartCategory cartCategory,double extraFees) {
        switch (cartCategory){
            case GOLD:
                extraFees= extraFees*0.65;
               break;
            case SILVER:
                 extraFees=extraFees*0.8;
                break;
            case BRONZE:
                 extraFees=extraFees*0.9;
              break;
        }return extraFees;

    }
}
