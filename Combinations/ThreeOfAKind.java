package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks if the hand has a Three of a Kind
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeOfAKind extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeOfAKind(Hand hand) {
        super(hand,5);
    }

    /**
     * Checks if the hand has a Three of a Kind
     * <p>Adds the 3 cards to the list of cards that the player should keep
     * @return True if there is a Three of a Kind
     */
    @Override
    boolean isCombination() {
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<3; i++){
            if (hand.get(i).value()==hand.get(i+1).value() && hand.get(i).value()==hand.get(i+2).value()){
                for (int j=i; j<i+3; j++){
                    _cardsToKeepList.set(j, true);
                }
                return true;
            }
        }
        return false;
    }

}
