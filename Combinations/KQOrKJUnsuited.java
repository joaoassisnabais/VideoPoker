package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

/**
 * Checks if the hand has a King and a Queen or a King and a Queen that do not have the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class KQOrKJUnsuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public KQOrKJUnsuited(Hand hand) {
        super(hand, 28);
    }

    /**
     * Checks if the hand has a King and a Queen or a King and a Queen that do not have the same suit
     * <p>Adds the King and Queen or King and Queen that do not have the same suit to the list of cards that the player should keep
     * @return True if there is a King and a Queen or a King and a Queen that do not have the same suit
     */
    @Override
    public boolean isCombination() {
        int king=-1, queen=-1, jack=-1;
        Suit suit;

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()==13){
                king=i;
            }
            if(hand.get(i).value()==12){
                queen=i;
            }
            if(hand.get(i).value()==11){
                jack=i;
            }
        }

        if (king!=-1){
            if(queen!=-1 && hand.get(king).suit() != hand.get(queen).suit()){
                _cardsToKeepList.set(king, true);
                _cardsToKeepList.set(queen, true);
                return true;
            }
            if(jack!=-1 && hand.get(king).suit() != hand.get(jack).suit()){
                _cardsToKeepList.set(king, true);
                _cardsToKeepList.set(jack, true);
                return true;
            }

        }
        return false;

    }

}

