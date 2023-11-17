package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Checks which type of hand there is and what cards should the player hold to achieve the perfect strategy
 */
public abstract class checkCombinations {

    /**
     * Hand in analysis
     */
    Hand hand;

    /**
     * Copy of the hand
     */
    final Hand trueHand;

    /**
     * Priority of the type of hand (combination)
     */
    private int Priority;

    /**
     * List of booleans that indicate the cards that the player should keep
     */
    List<Boolean> _cardsToKeepList;

    /**
     * Checks if the hand is of the type of hand (combination) given by the priority number
     * @param hand hand to analyse
     * @param priority priority of the  type of hand
     */
    public checkCombinations(Hand hand, int priority) {
        this.hand = new Hand(hand);
        this.trueHand = hand;
        this.Priority = priority;
        this._cardsToKeepList=new ArrayList<>();
        this.hand.sortDescendingOrder();
    }

    /**
     * Sets priority of a type of hand (combination)
     * @param priority value of the priority of the combination
     */
    void setPriority(int priority) {
        Priority = priority;
    }

    /**
     * gets the priority of a combination
     * @return value of the priority
     */
    int getPriority() {
        return Priority;
    }

    /**
     * Returns the true indexes of the cards in the hand
     * @param translate list of booleans that indicate the cards that need to know the true index
     * @return list with the true indexes
     */
    private List<Boolean> getTrueIndexes(List<Boolean> translate){
        List<Boolean> exit = new ArrayList<>(Arrays.asList(new Boolean[5]));
        Collections.fill(exit, false);
        for (int i = 0; i < 5; i++) {
            if(translate.get(i)) {
                exit.set(trueHand.getIndex(hand.get(i)), true);
            }
        }
        return exit;
    }

    /**
     * Checks if there is a type of hand (combination) in the hand
     * @return true if the hand has a combination
     */
    abstract boolean isCombination();

    /**
     * List of cards the player should keep according to the combination
     * @return list with the true indexes of the cards to keep
     */
    List<Boolean> cardsToKeep(){
        return getTrueIndexes(_cardsToKeepList);
    }
}
