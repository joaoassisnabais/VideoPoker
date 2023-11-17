package Combinations;

import Cards.Hand;
import java.util.*;

/**
 * Checks if there is only one card missing in the middle of the hand to get a Straight and if 2 of the cards of the Straight are High cards
 * <p>Adds the cards that the player should keep to a list
 */
public class FourToAnInsideStraightWithTwoHC extends FourToAnInsideStraightWithNoHC {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public FourToAnInsideStraightWithTwoHC(Hand hand) {
        super(hand);
        setPriority(19);
    }

    /**
     * Checks if it is a Four to An Inside Straight
     * <p>Checks if the hand has 2 High Cards
     * <p>Adds the four cards that will possibly make the Straight to the list of cards that the player should keep
     * @return True if the hand is a Four to An Inside Straight and has 2 High Cards
     */
    @Override
    boolean isCombination() {
        List<Integer> diffCard = new ArrayList<>(Arrays.asList(0, 0));
        List<Boolean> cardsTracker = new ArrayList<>(Arrays.asList(new Boolean[14]));   //track if a certain card was already found
        List<Integer> cardsExpected = new ArrayList<>(Arrays.asList(new Integer[5]));   //cards expected for a given first card
        int highCardCount, k;

        for (int j=0; true; j++){
            highCardCount = 0;
            k=0;
            Collections.fill(cardsTracker, Boolean.FALSE);

            for (int i=0; i<5; i++) {   //expected straight given j as a first card
                if (hand.get(j).value() - i == 1) {
                    cardsExpected.set(i, 14);   //expect ace after two
                } else {
                    cardsExpected.set(i, hand.get(j).value() - i);
                }
            }

            for (int i=0; i<5; i++) {
                if (!(cardsExpected.contains(hand.get(i).value()) && !cardsTracker.get(hand.get(i).value()-1))) {    //card not expected given Straight starting in j
                    if (k==1) {
                        k++;
                        break;  //break if more than 2 cards differ from the Straight
                    }
                    diffCard.set(k, i);
                    k++;
                } else {
                    if (hand.get(i).value()>=11) {  //keep track of high cards
                        highCardCount++;
                    }
                    cardsTracker.set(hand.get(i).value() - 1, true);  //flag card as already found
                }
            }
            if (k<=1 && highCardCount==2) {
                break;
            } else if (j==1) {  //a straight flush was not found
                return false;
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard.get(0),false);   //discard different cards


        return true;
    }
}
