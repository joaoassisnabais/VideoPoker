package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

/**
 * Checks if the hand has a King and a Ten with the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class KTSuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public KTSuited(Hand hand) {
        super(hand, 30);
    }

    /**
     * Checks if the hand has a King and a Ten with the same suit
     * <p>Adds the King and Ten with the same suit to the list of cards that the player should keep
     * @return True if there is a King and a Ten with the same suit
     */
    @Override
    public boolean isCombination() {
        int king=-1, ten=-1;
        Suit suit;

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()==13){
                king=i;
            }
            if(hand.get(i).value()==10){
                ten=i;
            }
        }

        try {
            if (king != -1 && ten != -1 && hand.get(king).suit() == hand.get(ten).suit()) {
                _cardsToKeepList.set(king, true);
                _cardsToKeepList.set(ten, true);
                return true;
            }
        }catch (IndexOutOfBoundsException ignored){
        }

        return false;

    }

}
