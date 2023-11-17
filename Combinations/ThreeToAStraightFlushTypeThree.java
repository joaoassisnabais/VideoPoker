package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;
import static Cards.Suit.S;

/**
 * Checks if there are two cards missing in the hand to get a Straight Flush (Type 3)
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeToAStraightFlushTypeThree extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeToAStraightFlushTypeThree(Hand hand) {
        super(hand, 27);
    }

    /**
     * Checks if there here are two cards missing in the hand to get a Straight Flush with two gaps and no high cards
     * <p>Adds the three cards that will possibly make the Straight Flush to the list of cards that the player should keep
     * @return True if there here are two cards missing in the hand to get a Straight Flush with two gaps and no high cards
     */
    @Override
    boolean isCombination() {
        List<Integer> diffCard = new ArrayList<>(Arrays.asList(0, 0));
        List<Boolean> cardsTracker = new ArrayList<>(Arrays.asList(new Boolean[14]));   //track if a certain card was already found
        List<Integer> cardsExpected = new ArrayList<>(Arrays.asList(new Integer[5]));   //cards expected for a given first card
        int highCardCount, k;

        Suit mostFreqSuit;
        Map<Suit, Integer> suitMap = new EnumMap<>(Suit.class); //map of suit frequencies
        suitMap.put(D,0);
        suitMap.put(C,0);
        suitMap.put(H,0);
        suitMap.put(S,0);

        for (int i=0; i<5; i++){
            switch (hand.get(i).suit()){
                case C -> suitMap.put(C, suitMap.get(C) + 1);
                case D -> suitMap.put(D, suitMap.get(D) + 1);
                case H -> suitMap.put(H, suitMap.get(H) + 1);
                case S -> suitMap.put(S, suitMap.get(S) + 1);
            }
        }

        mostFreqSuit = Collections.max(suitMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        for (int j=0; true; j++){
            highCardCount = 0;
            k=0;
            Collections.fill(cardsTracker, Boolean.FALSE);

            for (int i=0; i<5; i++) {   //expected straight given j as a first card
                cardsExpected.set(i, hand.get(j).value() - i);
            }

            for (int i=0; i<5; i++) {
                if (!(cardsExpected.contains(hand.get(i).value()) && !cardsTracker.get(hand.get(i).value()-1) && hand.get(i).suit()==mostFreqSuit)) {    //card not expected given Straight starting in j
                    if (k==2) {
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
            if (k<=2 && highCardCount>=0) { //a straight flush of type 3 was found
                break;
            } else if (j==2) {  //a straight flush was not found
                return false;
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard.get(0),false);   //discard different cards
        _cardsToKeepList.set(diffCard.get(1),false);

        return true;
    }

}
