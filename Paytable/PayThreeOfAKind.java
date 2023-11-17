package Paytable;

/**
 * Contains the payment values for the Three of a Kind combination
 */
public class PayThreeOfAKind extends Payment{

    /**
     * Contains an array with the payment values for the Three of a Kind combination, according to credit
     */
    public PayThreeOfAKind(){
        payLine=new int[] {3, 6, 9, 12, 15};
    }

}
