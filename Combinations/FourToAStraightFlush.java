package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;
import static Cards.Suit.S;

/**
 * Checks if there is only one card missing to have a Straight Flush
 * <p>Adds the cards that the player should keep to a list
 */
public class FourToAStraightFlush extends checkCombinations {

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public FourToAStraightFlush(Hand hand) {
        super(hand, 6);
    }

    /**
     * Checks if there is only one card missing in one of the edge of the hand to get a Straight Flush
     * <p>Adds the four cards that will possibly make the Straight Flush to the list of cards that the player should keep
     * @return True if there is only one card missing in the hand to get a Straight Flush
     */
    @Override
    boolean isCombination() {
        List<Boolean> cardsTracker = new ArrayList<>(Arrays.asList(new Boolean[14]));   //track if a certain card was already found
        List<Integer> cardsExpected = new ArrayList<>(Arrays.asList(new Integer[5]));   //cards expected for a given first card
        int diffCard = 0;
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
                if (!(cardsExpected.contains(hand.get(i).value()) && !cardsTracker.get(hand.get(i).value()-1) && hand.get(i).suit()==mostFreqSuit)) {    //card not expected given Straight starting in j
                    if (k==1) {
                        k++;
                        break;  //break if more than 2 cards differ from the Straight
                    }
                    diffCard = i;
                    k++;
                } else {
                    cardsTracker.set(hand.get(i).value() - 1, true);  //flag card as already found
                }
            }
            if (k<=1) { //a straight flush was found
                break;
            } else if (j==1) {  //a straight flush was not found
                return false;
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard,false);   //discard different card

        return true;
    }

}
