package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

/**
 * Checks if the hand has a Queen and a Ten with the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class QTSuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public QTSuited(Hand hand) {
        super(hand, 26);
    }

    /**
     * Checks if the hand has a Queen and a Ten with the same suit
     * <p>Adds the Queen and Ten with the same suit to the list of cards that the player should keep
     * @return True if there is a Queen and a Ten with the same suit
     */
    @Override
    public boolean isCombination() {
        int queen=-1, ten=-1;

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        for (int i=0; i<5; i++){
            if(hand.get(i).value()==12){
                queen=i;
            }
            if(hand.get(i).value()==10){
                ten=i;
            }

        }

        if (queen!=-1 && ten!=-1 && hand.get(queen).suit()==hand.get(ten).suit()){
            _cardsToKeepList.set(queen, true);
            _cardsToKeepList.set(ten, true);
            return true;

        }
        return false;

    }

}

