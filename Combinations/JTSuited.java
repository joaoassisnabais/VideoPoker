package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

/**
 * Checks if the hand has a Jack and a Ten with the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class JTSuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public JTSuited(Hand hand) {
        super(hand, 23);
    }

    /**
     * Checks if the hand has a Jack and a Ten with the same suit
     * <p>Adds the Jack and the Ten with the same suit to the list of cards that the player should keep
     * @return True if there is a Jack and a Ten with the same suit
     */
    @Override
    public boolean isCombination() {
        int jack=-1, ten=-1;
        Suit suit;

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()==11){
                jack=i;
            }
            if(hand.get(i).value()==10){
                ten=i;
            }
        }

        if (jack!=-1 && ten!=-1 && hand.get(jack).suit()==hand.get(ten).suit()){
            _cardsToKeepList.set(jack, true);
            _cardsToKeepList.set(ten, true);
            return true;
        }
        return false;

    }

}

