package Combinations;

import Cards.Hand;

import java.util.*;

/**
 * Checks if the hand has a Jack, Queen or King that do not have the same suit
 * <p>Adds the cards that the player should keep to a list
 */
public class KQJUnsuited extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public KQJUnsuited(Hand hand) {
        super(hand, 22);
    }

    /**
     * Checks if the hand has a Jack, Queen or King that do not have the same suit
     * <p>Adds the Jack, Queen or King that do not have the same suit to the list of cards that the player should keep
     * @return True if there is a Jack, Queen or King that do not have the same suit
     */
    @Override
    public boolean isCombination() {
        int king=-1, queen=-1, jack=-1;

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

        if (king!=-1 && queen!=-1 && jack!=-1 && (hand.get(king).suit()!=hand.get(queen).suit() || hand.get(king).suit()!=hand.get(jack).suit() || hand.get(queen).suit()!=hand.get(jack).suit())){
            _cardsToKeepList.add(jack, true);
            _cardsToKeepList.add(queen, true);
            _cardsToKeepList.add(king, true);
            return true;

        }
        return false;

    }

}

