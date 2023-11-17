package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks if the hand has Straight Flush, Four of a Kind or Royal Flush
 * <p>Adds the cards that the player should keep to a list
 */
public class RoyalFlush extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public RoyalFlush(Hand hand) {
        super(hand, 1);
    }

    /**
     * Checks if the hand has Straight Flush, Four of a Kind or Royal Flush
     * <p>Adds combination found to the list of cards that the player should keep
     * @return True if there is a Straight Flush, Four of a Kind or Royal Flush
     */
    @Override
    public boolean isCombination() {
        boolean isRoyalFlush = true;
        boolean isStraightFlush = true;
        boolean isFourOfKind = true;

        for (int i=0; i<4; i++){    //is Royal Flush?
            if (!(hand.get(i).value()==14-i && hand.get(i).value()==hand.get(i+1).value()+1 && hand.get(i).suit()==hand.get(i+1).suit())){
                isRoyalFlush = false;
                break;
            }
        }

        for (int i=0; i<4; i++){    //is Straight Flush?
            if (!(hand.get(i).value()==hand.get(i+1).value()+1 && hand.get(i).suit()==hand.get(i+1).suit())){
                isStraightFlush = false;
                break;
            }
        }

        for (int j=0; j<2; j++){    //is Four of a Kind?
            isFourOfKind = true;
            for (int i=j; i<j+3; i++){
                if (!(hand.get(i).value()==hand.get(i+1).value())){
                    isFourOfKind = false;
                    break;
                }
            }
            if (isFourOfKind) {
                break;
            }
        }

        if (isFourOfKind || isStraightFlush || isRoyalFlush){
            _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
            return true;
        }

        return false;
    }

}
