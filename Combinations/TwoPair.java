package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks if the hand has a Two Pair
 * <p>Adds the cards that the player should keep to a list
 */
public class TwoPair extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public TwoPair(Hand hand) {
        super(hand, 7);
    }

    /**
     * Checks if the hand has a Two pair
     * <p>Adds the four cards to the list of cards that the player should keep
     * @return True if there is a Two pair
     */
    @Override
    boolean isCombination() {
        int isPair = 0;
        int diffCard = -1;

        for (int i=0; i<4; i++){
            if (hand.get(i).value()==hand.get(i+1).value()){
                isPair++;
                i++;
            }
            else {
                diffCard = i;
            }
        }
        if(diffCard==-1) diffCard = 4;

        if (isPair==2) {
            _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
            _cardsToKeepList.set(diffCard, false);
            return true;
        }

        return false;
    }

}
