package Paytable;


/**
 * Contains the payment values for the Straight combination
 */
public class PayStraight extends Payment {

    /**
     * Contains an array with the payment values for the Straight combination, according to credit
     */
    public PayStraight(){
        payLine= new int[]{5, 10, 15, 20, 25};
    }
}
