package Paytable;

/**
 * Contains the payment values for the Flush combination
 */
public class PayFlush extends Payment{

    /**
     * Contains an array with the payment values for the Flush combination, according to credit
     */
    public PayFlush(){
        payLine=new int[] {7, 14, 21, 28, 35};
    }
}
