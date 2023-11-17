package Combinations;

import Cards.Hand;
import java.util.*;

/**
 * Checks if there is an Ace in the hand.
 * <p>Adds the cards that the player should keep to a list
 */
public class Ace extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public Ace(Hand hand) {
        super(hand, 29);
    }

    /**
     * Checks if there is an Ace in the hand.
     * <p>Adds the ace to the list of cards that the player should keep
     * @return True if there is an Ace in the hand
     */
    @Override
    public boolean isCombination() {

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()==14){
               _cardsToKeepList.set(i, true);
               return true;
            }
        }

        return false;
    }
}
