package Combinations;

import Cards.Hand;

import java.util.*;

/**
 * Checks if the hand has a Jack, Queen or King
 * <p>Adds the cards that the player should keep to a list
 */
public class JackQueenOrKing extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public JackQueenOrKing(Hand hand) {
        super(hand, 31);
    }

    /**
     * Checks if the hand has a Jack, Queen or King
     * <p>Adds the cards with the  values J, Q or K to the list of cards that the player should keep
     * @return True if there is a Jack, Queen or King
     */
    @Override
    public boolean isCombination() {

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for(int i=0; i<5; i++){
           if(hand.get(i).value()>=11 && hand.get(i).value()<=13){
               _cardsToKeepList.set(i, true);
               return true;
           }
        }

        return false;
    }

}
