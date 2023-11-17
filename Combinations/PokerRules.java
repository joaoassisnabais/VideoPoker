package Combinations;

import Cards.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contains the special hand according to the type of poker game in play
 * <p>In this case the rules are the ones to have the perfect strategy in double bonus
 */
public class PokerRules {

    /**
     * List of booleans indicating if there is a combination
     */
    static List<checkCombinations> L= new ArrayList<>();

    /**
     * Adds combination to list of combinations
     * @param combination combination to add to the list
     */
    static void register(checkCombinations combination){
        L.add(combination);
    }

    /**
     * Registers the hand in the combinations
     * @param hand hand to check
     */
    private void registerAll(Hand hand) {
        register(new Ace(hand));
        register(new AKQJUnsuited(hand));
        register(new FourToAFlush(hand));
        register(new FourToAnInsideStraightWithNoHC(hand));
        register(new FourToAnInsideStraightWithOneHC(hand));
        register(new FourToAnInsideStraightWithThreeHC(hand));
        register(new FourToAnInsideStraightWithTwoHC(hand));
        register(new FourToAnOutsideStraight(hand));
        register(new FourToARoyalFlush(hand));
        register(new FourToAStraightFlush(hand));
        register(new HighPair(hand));
        register(new JackQueenOrKing(hand));
        register(new JTSuited(hand));
        register(new KQJUnsuited(hand));
        register(new KQOrKJUnsuited(hand));
        register(new KTSuited(hand));
        register(new LowPair(hand));
        register(new QJSuited(hand));
        register(new QJUnsuited(hand));
        register(new QTSuited(hand));
        register(new RoyalFlush(hand));
        register(new StraightFlushFullHouse(hand));
        register(new ThreeAces(hand));
        register(new ThreeOfAKind(hand));
        register(new ThreeToAFlushWithNoHC(hand));
        register(new ThreeToAFlushWithOneHC(hand));
        register(new ThreeToAFlushWithTwoHC(hand));
        register(new ThreeToARoyalFlush(hand));
        register(new ThreeToAStraightFlushTypeOne(hand));
        register(new ThreeToAStraightFlushTypeThree(hand));
        register(new ThreeToAStraightFlushTypeTwo(hand));
        register(new TwoPair(hand));
        register(new TwoSuitedHighCards(hand));
        //Sort from 1 to 33
        L.sort(Comparator.comparingInt(checkCombinations::getPriority));
    }

    /**
     * Checks if there is a combination in the hand
     * @param hand hand to analyse
     * @return list of cards to keep if there is a combination
     */
    public List<Boolean> Advice(Hand hand){
        L.clear();
        registerAll(hand);
        for (checkCombinations combo: L) {
            if(combo.isCombination())
                return combo.cardsToKeep();
        }
        List<Boolean> exit=new ArrayList<>();
        Collections.fill(exit, false);
        return exit;
    }
}
