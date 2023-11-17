package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Checks if the hand has Straight, Flush or Full House
 * <p>Adds the cards that the player should keep to a list
 */
public class StraightFlushFullHouse extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public StraightFlushFullHouse(Hand hand) {
        super(hand, 4);
    }

    /**
     * Checks if the hand has a Straight, Flush or Full House
     * <p>Adds combination found to the list of cards that the player should keep
     * @return True if there is a Straight, Flush or Full House
     */
    @Override
    boolean isCombination() {
        boolean isFlush = true;
        boolean isStraight = true;
        boolean isFullHouse = true;
        int diffCardCounter = 0;

        for (int i=0; i<4; i++){    //is Flush?
            if (!(hand.get(i).suit()==hand.get(i+1).suit())){
                isFlush = false;
                break;
            }
        }

        for (int i=0; i<4; i++){    //is Straight?
            if (!((hand.get(i).value()==hand.get(i+1).value()+1) || (hand.get(0).value()==14 && hand.get(i+1).value()==5 && i==0))){
                isStraight = false;
                break;
            }
        }

        for (int i=0; i<4; i++){    //isFullHouse
            if (!(hand.get(i).value()==hand.get(i+1).value())){
                if (diffCardCounter>=1){
                    isFullHouse = false;
                    break;
                }
                diffCardCounter++;
            }
        }
        if (isFlush || isStraight || isFullHouse){
            _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
            return true;
        }
        return false;
    }

}
