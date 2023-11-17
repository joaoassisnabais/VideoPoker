package Paytable;

/**
 * Contains the payment values for the Four of a Kind combination
 */
public class PayFourOfAKind extends Payment {

    /**
     * Contains arrays with the payment values for the Four of a Kind combination, according to credit and the repeated card
     * @param repeatedCard repeated card in the hand, that will determine if the combination is a Four Aces, Four 2-4 or a Four 5-K
     */
    public PayFourOfAKind(int repeatedCard){
        //Four Aces
        if(repeatedCard==14)
            payLine=new int[]{160, 320, 480, 640, 800};
        //Four 2-4
        else if(repeatedCard>=2 && repeatedCard<=4)
            payLine=new int[]{80, 160, 240, 320, 400};
        //Four 5-K
        else
            payLine=new int[]{50, 100, 150, 200, 250};
    }
}
