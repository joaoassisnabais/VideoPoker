package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

/**
 * Checks if the hand has a Queen and a Jack with the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class QJSuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public QJSuited(Hand hand) {
        super(hand, 16);
    }

    /**
     * Checks if the hand has a Queen and a Jack with the same suit
     * <p>Adds the Queen and Jack with the same suit to the list of cards that the player should keep
     * @return True if there is a Queen and a Jack with the same suit
     */
    @Override
    public boolean isCombination() {
        int queen=-1, jack=-1;

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()==12){
                queen=i;
            }
            if(hand.get(i).value()==11){
                jack=i;
            }

        }

        if (queen!=-1 && jack!=-1 && hand.get(queen).suit()==hand.get(jack).suit()){
            _cardsToKeepList.set(queen, true);
            _cardsToKeepList.set(jack, true);
            return true;
        }
        return false;

    }

}

