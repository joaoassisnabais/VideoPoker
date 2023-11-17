package Paytable;

/**
 * Contains the payment values for the Straight Flush combination
 */
public class PayStraightFlush extends Payment{

    /**
     * Contains arrays with the payment values for the Four of a Kind combination, according to credit and the highest card of the hand
     * @param highestCard highest card in the hand, that will determine if the combination is a Royal Flush or a Straight Flush
     */
    public PayStraightFlush(int highestCard){
        //Royal Flush
        if(highestCard==14)
            payLine=new int[]{250, 500, 750, 1000, 4000};
        //Straight Flush
        else
            payLine=new int[]{50, 100, 150, 200, 250};
    }
}
