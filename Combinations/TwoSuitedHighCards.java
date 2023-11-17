package Combinations;

import Cards.Hand;

import java.util.*;

/**
 * Checks if the hand has a Two Suited High Cards
 * <p>Adds the cards that the player should keep to a list
 */
public class TwoSuitedHighCards extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public TwoSuitedHighCards(Hand hand) {
        super(hand, 18);
    }

    /**
     * Checks if the hand has a Two Suited High Cards
     * <p>Adds the Two Suited High Cards to the list of cards that the player should keep
     * @return True if there are Two Suited High Cards
     */
    @Override
    public boolean isCombination() {
        int highCard=0;
        List<Integer> index = new ArrayList<>();
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(false, false, false, false, false)));

        for (int i=0; i<5; i++){
            if(hand.get(i).value()>=11){
                highCard++;
                index.add(i);
            }
        }
        
        if (highCard!=2){
            return false;
        } else if (hand.get(index.get(0)).suit() == hand.get(index.get(1)).suit()){
            _cardsToKeepList.add(index.get(0),true);
            _cardsToKeepList.add(index.get(1),true);
            return true;
        }

        return false;

    }

}

