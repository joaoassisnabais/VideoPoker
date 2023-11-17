package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks if the hand has a Low Pair
 * <p>Adds the cards that the player should keep to a list
 */
public class LowPair extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public LowPair(Hand hand) {
        super(hand, 12);
    }

    /**
     * Checks if the hand has a pair with no high cards
     * <p>Adds the two paired cards to the list of cards that the player should keep
     * @return True if there is a High Pair
     */
    @Override
    boolean isCombination() {

        for (int i=0; i<4; i++){
            if (hand.get(i).value()==hand.get(i+1).value() && hand.get(i).value()<=10) {
                _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));
                _cardsToKeepList.set(i, true);
                _cardsToKeepList.set(i+1, true);
                return true;
            }
        }
        return false;
    }

}
