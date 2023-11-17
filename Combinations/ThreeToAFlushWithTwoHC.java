package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;

/**
 * Checks if there is only one card missing in the hand to get a Flush and if 2 of the cards of the Flush is a High card
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeToAFlushWithTwoHC extends ThreeToAFlushWithNoHC {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeToAFlushWithTwoHC(Hand hand) {
        super(hand);
        setPriority(17);
    }

    /**
     * Checks if it is a Three to a Flush
     * <p>Checks if the hand has 2 High Cards
     * <p>Adds the three cards that will possibly make the Flush to the list of cards that the player should keep
     * @return True if the hand is Three to a Flush and has 2 High Cards
     */
    @Override
    public boolean isCombination() {
        if(!super.isCombination()){
            return false;
        }

        int highCard=0;
        for(int i=0; i<5; i++){
            if(hand.get(i).value()>=11 && hand.get(i).suit()==mostFreqSuit){
               highCard++;
            }
            if(highCard==2){
                return true;
            }
        }

        return false;
    }
}