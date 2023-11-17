package Combinations;

import Cards.Hand;
import Cards.Suit;

import java.util.*;

import static Cards.Suit.*;

/**
 * Checks if there are two cards missing in the hand to get a Flush
 * <p>Adds the cards that the player should keep to a list
 */
public class ThreeToAFlushWithNoHC extends checkCombinations {

    /**
     * variable to check the most frequent suit in the hand
     */
    Suit mostFreqSuit;

    /**
     * Constructor of the hand
     * @param hand hand of cards in analysis
     */
    public ThreeToAFlushWithNoHC(Hand hand) {
        super(hand, 33);
    }

    /**
     * Checks if there here are two cards missing in the hand to get a Flush
     * <p>Adds the four cards that will possibly make the Flush to the list of cards that the player should keep
     * @return True if there are two cards missing in the hand to get a Flush
     */
    @Override
    public boolean isCombination() {
        List<Integer> diffCard = new ArrayList<>();  //card missing to RF
        Map<Suit, Integer> suitMap = new EnumMap<>(Suit.class); //map od suit frequencies
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

        if(suitMap.get(mostFreqSuit)!=3){
            return false;
        }

        _cardsToKeepList.addAll(new ArrayList<>(Arrays.asList(true, true, true, true, true)));

        for (int i = 0; i < 5; i++) {
            if(hand.get(i).suit()!=mostFreqSuit){
                diffCard.add(i);
            }
        }

        _cardsToKeepList.set(diffCard.get(0), false);
        _cardsToKeepList.set(diffCard.get(1), false);

        return true;
    }

}
