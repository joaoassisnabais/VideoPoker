package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Checks if there is only one card missing in one of the edge of the hand to get a Straight
 * <p>Adds the cards that the player should keep to a list
 */
public class FourToAnOutsideStraight extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public FourToAnOutsideStraight(Hand hand) {
        super(hand, 11);
    }

    /**
     * Checks if there is only one card missing in one of the edge of the hand to get a Straight
     * <p>Adds the four cards that will possibly make the Straight to the list of cards that the player should keep
     * @return True if there is only one card missing in the hand to get a Straight
     */
    @Override
    boolean isCombination() {
        int diffCard = -1;

        for (int j=0; j<2; j++){    //check first 4 cards
            for (int i=j; i<j+3; i++){
                if (!(hand.get(i).value()==hand.get(i+1).value()+1)){
                    if (diffCard!=-1) {
                        return false;   //false if both first and final 4 cards verifications fail
                    }
                    diffCard = j*4; //diffCard = 0 for first card and = 4 for last card
                }
            }
        }
        if (diffCard == 4 && hand.get(0).value()==14) { //account for JQKA
            return false;
        }

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard, false);
        return true;
    }

}
