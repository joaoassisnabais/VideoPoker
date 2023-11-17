package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks if the hand has 3 Aces
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeAces extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeAces(Hand hand) {
        super(hand, 3);
    }

    /**
     * Checks if the hand has 3 Aces
     * <p>Adds the 3 Aces to the list of cards that the player should keep
     * @return True if there are 3 Aces
     */
    @Override
    boolean isCombination() {
        for (int i=0; i<3; i++){
            if (hand.get(i).value()!=14){
                return false;
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, false, false)));
        return true;
    }

}
