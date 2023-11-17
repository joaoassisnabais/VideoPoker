package Paytable;

/**
 * Class to implement the factory design pattern to process the payments according to the combination
 */
public class PaymentFactory {

    /**
     * Implements he factory design pattern to
     * @param index indicates the combination
     * @param interestCard indicates special cases in some combinations
     * @return pay line of the combination
     */
    public static Payment getPayment(int index, int interestCard) {
        return switch (index) {
            case 1 -> new PayJacksOrBetter();
            case 2 -> new PayTwoPair();
            case 3 -> new PayThreeOfAKind();
            case 4 -> new PayStraight();
            case 5 -> new PayFlush();
            case 6 -> new PayFullHouse();
            case 7 -> new PayFourOfAKind(interestCard);
            case 8 -> new PayStraightFlush(interestCard);
            default -> new PayNothing();
        };
    }

}
