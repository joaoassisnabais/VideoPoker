package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;
import static Cards.Suit.S;

/**
 * Checks if there is only one card missing in the hand to get a Flush.
 * <p>Adds the cards that the player should keep to a list
 */
public class FourToAFlush extends checkCombinations{

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public FourToAFlush(Hand hand) {
        super(hand, 9);
    }

    /**
     * Checks if there is only one card missing in the hand to get a Flush.
     * <p>Adds four cards that will possibly make the Flush to the list of cards that the player should keep
     * @return True if there is only one card missing in the hand to get a Flush
     */
    @Override
    boolean isCombination() {
        int diffCard = -1;

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

        for (int i=0; i<5; i++){
            if (hand.get(i).suit()!=mostFreqSuit) {
                if (diffCard!=-1) { //more than 1 card to Flush
                    return false;
                }
                diffCard = i;
            }
        }
        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        _cardsToKeepList.set(diffCard,false);   //discard only different card

        return true;
    }

}
