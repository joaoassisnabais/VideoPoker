package Paytable;

/**
 * Contains a payment with only zeros
 */
public class PayNothing extends Payment {
    /**
     * Contains an array with only zeros
     */
    public PayNothing(){
        payLine= new int[]{0, 0, 0, 0, 0};
    }
}
