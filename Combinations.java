import Cards.*;

/**
 * Checks the combination of the hand
 */
public class Combinations{

    /**
     * hand to analyse
     */
    Hand hand;

    /**
     * Constructor of the hand to analyse
     * @param hand hand to analyse
     */
    public Combinations(Hand hand){
        this.hand=new Hand(hand);
        this.hand.sortAscendingOrder();
    }

    /**
     * Check which combination is in the hand and adds it to the respective field in the statistics
     * @param stats number of times that the different combinations ware found during the game
     * @return combination index and interest card
     */
    public CombinationsOutput checkCombo(Statistics stats){
        int exit;

        exit=DoRoyalFlush();
        if(exit!=-1) {
            stats.incrementRoyalFlush();
            return new CombinationsOutput("ROYAL FLUSH", exit, 8);
        }
        exit=DoStraightFlush();
        if(exit!=-1) {
            stats.incrementStraightFlush();
            return new CombinationsOutput("STRAIGHT FLUSH", exit, 8);
        }
        exit=DoFourOfAKind();
        if(exit!=-1) {
            stats.incrementFourOfAKind();
            return new CombinationsOutput("FOUR OF A KIND", exit, 7);
        }
        exit=DoFullHouse();
        if(exit!=-1) {
            stats.incrementFullHouse();
            return new CombinationsOutput("FULL HOUSE", exit, 6);
        }
        exit=DoFlush();
        if(exit!=-1) {
            stats.incrementFlush();
            return new CombinationsOutput("FLUSH", exit, 5);
        }
        exit=DoStraight();
        if(exit!=-1) {
            stats.incrementStraight();
            return new CombinationsOutput("STRAIGHT", exit, 4);
        }
        exit=DoThreeOfAKind();
        if(exit!=-1) {
            stats.incrementThreeOfAKind();
            return new CombinationsOutput("THREE OF A KIND", exit, 3);
        }
        exit=DoTwoPair();
        if(exit!=-1) {
            stats.incrementTwoPair();
            return new CombinationsOutput("TWO PAIR", exit, 2);
        }
        exit=DoJacksOrBetter();
        if(exit!=-1) {
            stats.incrementJacksOrBetter();
            return new CombinationsOutput("JACKS OR BETTER", exit, 1);
        }

        stats.incrementOther();
        return new CombinationsOutput("", exit, 0);

    }

    /**
     * Checks if the hand is a Royal Flush
     * @return Value of the highest card (14) if it is a royal flush and -1 if it isn't
     */
    public int DoRoyalFlush(){
        if(DoStraightFlush()==14)
            return 14;
        else return -1;
    }

    /**
     * Checks if the hand is a Straight Flush
     * @return Value of the highest card if it is a Straight Flush and -1 if it isn't
     */
    public int DoStraightFlush(){
        int highCard=-1, isStraight, isFlush;
        isStraight=DoStraight();
        isFlush=DoFlush();
        if(isStraight!=-1 && isFlush!=-1){
            highCard=isStraight;
        }
        return highCard;
    }

    /**
     * Checks if the hand is a Four of a Kind
     * @return value of the repeated card (4 times) if it is a Four of a Kind and -1 if it isn't
     */
    public int DoFourOfAKind(){
        int repeatedCard=-1;

        for(int i=0; i<2; i++){
            if (hand.get(i).value()==hand.get(i+1).value() &&
                    hand.get(i+1).value()==hand.get(i+2).value() && hand.get(i+2).value() == hand.get(i+3).value())
                repeatedCard = hand.get(i).value();
        }

        return repeatedCard;
    }

    /**
     * Checks if the hand is a Full House
     * @return value of the repeated card (3 times) if it is a Full House and -1 if it isn't
     */
    public int DoFullHouse(){
        int thriceRepeatedCard=-1;

        if(hand.get(0).value()==hand.get(1).value() && hand.get(2).value()==hand.get(3).value() &&
           hand.get(3).value()==hand.get(4).value()) {
            thriceRepeatedCard = hand.get(3).value();
        }
        if(hand.get(0).value()==hand.get(1).value() && hand.get(1).value()==hand.get(2).value() &&
                hand.get(3).value()==hand.get(4).value()) {
            thriceRepeatedCard = hand.get(0).value();
        }
        return thriceRepeatedCard;
    }

    /**
     * Checks if the hand is a Flush
     * @return value of the highest card if it is a Flush and -1 if it isn't
     */
    public int DoFlush(){
        int highCard=-1, isFlush=0;
        for(int i=0; i<4; i++) {
            if (hand.get(i).suit() == hand.get(i + 1).suit()) {
                isFlush++;
            }
        }
        if(isFlush==4) highCard=hand.get(4).value();
        return highCard;
    }

    /**
     * Checks if the hand is a Straight
     * @return value of the highest card if it is a Straight and -1 if it isn't
     */
    public int DoStraight(){
        int highCard=-1, isStraight=0;

        //checks if it is a straight without A->5
        for(int i=0; i<4; i++) {
            if (hand.get(i).value() + 1 == hand.get(i + 1).value()) {
                isStraight++;
            }
        }
        //sees if it is a normal straight
        if(isStraight==4) highCard=hand.get(4).value();

        //sees if it is an A->5
        else if(hand.get(4).value()==14 && hand.get(0).value()==2 && hand.get(1).value()==3 &&
                hand.get(2).value()==4 && hand.get(3).value()==5 ){
            highCard=hand.get(3).value();
        }

        return highCard;
    }

    /**
     * Checks if the hand is a Three of a Kind
     * @return value of the repeated card if it is a Three of a Kind and -1 if it isn't
     */
    public int DoThreeOfAKind(){
        int repeatedCard=-1;

        for(int i=0; i<3; i++){
            if (hand.get(i).value()==hand.get(i+1).value() &&
                hand.get(i+1).value()==hand.get(i+2).value())
                repeatedCard = hand.get(i).value();
        }

        return repeatedCard;
    }

    /**
     * Checks if the hand is a Two Pair
     * @return value of the highest repeated cards if it is a Two Pair and -1 if it isn't
     */
    public int DoTwoPair(){
        int[] repeatedCards={-1, -1};
        int counter=0;
        for(int i=0; i<4; i++){
            if (hand.get(i).value()==hand.get(i+1).value()) {
                repeatedCards[counter] = hand.get(i).value();
                counter++;
                i++;
            }
        }

        return repeatedCards[1];
    }

    /**
     * Checks if the hand is a Jacks or Better
     * @return value of the repeated card if it is a Jacks or Better and -1 if it isn't
     */
    public int DoJacksOrBetter(){
        int repeatedCard=-1;

        for(int i=0; i<4; i++){
            if (hand.get(i).value()==hand.get(i+1).value())
                if (hand.get(i).value()>repeatedCard)    //Not really necessary because the cards are ordered but still it looks better, and I might be forgetting something
                    repeatedCard = hand.get(i).value();
        }

        if(repeatedCard < 11) repeatedCard=-1;
        return repeatedCard;
    }
 }
