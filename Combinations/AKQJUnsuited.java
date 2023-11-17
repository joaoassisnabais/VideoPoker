package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Checks if the cards AKQJ with different suits exist in the hand
 * <p>Adds the cards that the player should keep to a list
 */
public class AKQJUnsuited extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public AKQJUnsuited(Hand hand) {
        super(hand, 13);
    }

    /**
     * Checks if the cards AKQJ with different suits exist in the hand.
     * <p>Adds the unsuited AKQJ to the list of cards that the player should keep
     * @return True if there is AKQJ with different suits
     */
    @Override
    boolean isCombination() {
        List<Boolean> cardsTracker = new ArrayList<>(Arrays.asList(new Boolean[14])); //track if a certain card was already found
        Collections.fill(cardsTracker, Boolean.FALSE);
        int diffCard = -1;  //card that is not A,K,Q or J

        for (int i=0; i<5; i++){
            if (!(hand.get(i).value()<=14 && hand.get(i).value()>=11 && !cardsTracker.get(hand.get(i).value() - 1))){
                if (diffCard!=-1){  //more than 1 card to AKQJ unsuited
                    return false;
                }
                diffCard = i;
            } else {
                cardsTracker.set(hand.get(i).value() - 1, true);  //flag card as already found
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard,false);   //discard only different card

        return true;
    }

}
