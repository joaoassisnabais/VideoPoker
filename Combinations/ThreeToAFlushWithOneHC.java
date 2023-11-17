package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;

/**
 * Checks if there is only one card missing in the hand to get a Flush and if one of the cards of the Flush is a High card
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeToAFlushWithOneHC extends ThreeToAFlushWithNoHC {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeToAFlushWithOneHC(Hand hand) {
        super(hand);
        setPriority(25);
    }

    /**
     * Checks if it is a Three to a Flush
     * <p>Checks if the hand has a High Card
     * <p>Adds the three cards that will possibly make the Flush to the list of cards that the player should keep
     * @return True if the hand is Three to a Flush and has a High Card
     */
    @Override
    public boolean isCombination() {
        if(!super.isCombination()){
            return false;
        }

        for(int i=0; i<5; i++){
            if(hand.get(i).value()>=11 && hand.get(i).suit()==mostFreqSuit){
                return true;
            }
        }

        return false;
    }
}

