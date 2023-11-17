package Paytable;

/**
 * Contains the payment values for the Full House combination
 */
public class PayFullHouse extends Payment {

    /**
     * Contains an array with the payment values for the Full House combination, according to credit
     */
    public PayFullHouse(){
        payLine=new int[] {10, 20, 30, 40, 50};
    }
}
