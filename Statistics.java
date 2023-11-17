/**
 * Implements the statistics for the simulation game and for the s command in debug mode
 */
public class Statistics {
    private int jacksOrBetter =0;
    private int twoPair =0;
    private int threeOfAKind =0;
    private int straight =0;
    private int flush =0;
    private int fullHouse =0;
    private int fourOfAKind =0;
    private int straightFlush =0;
    private int royalFlush =0;
    private int other=0;
    private final long sumOfAllBets;
    private long sumOfAllGains=0;

    /**
     * Updates the sum of all bets
     * @param sumOfAllBets value of the sum of all bets
     */
    public Statistics(long sumOfAllBets){
        this.sumOfAllBets=sumOfAllBets;
    }

    /**
     * Updates the number of occurrences of the Jacks or Better combination
     */
    public void incrementJacksOrBetter(){
        jacksOrBetter++;
    }

    /**
     * Updates the number of occurrences of the Two Pair combination
     */
    public void incrementTwoPair(){
        twoPair++;
    }

    /**
     * Updates the number of occurrences of the Three of a King combination
     */
    public void incrementThreeOfAKind(){
        threeOfAKind++;
    }

    /**
     * Updates the number of occurrences of the Straight combination
     */
    public void incrementStraight(){
        straight++;
    }

    /**
     * Updates the number of occurrences of the Flush combination
     */
    public void incrementFlush(){
        flush++;
    }

    /**
     * Updates the number of occurrences of the Full House combination
     */
    public void incrementFullHouse(){
        fullHouse++;
    }

    /**
     * Updates the number of occurrences of the Four of a Kind combination
     */
    public void incrementFourOfAKind(){
        fourOfAKind++;
    }

    /**
     * Updates the number of occurrences of the Straight Flush combination
     */
    public void incrementStraightFlush(){
        straightFlush++;
    }

    /**
     * Updates the number of occurrences of the Royal Flush combination
     */
    public void incrementRoyalFlush(){
        royalFlush++;
    }

    /**
     * Updates the number of occurrences of no combination
     */
    public void incrementOther(){
        other++;
    }

    /**
     * Updates the sum of all the gains
     */
    public void updateSum(int added){
        sumOfAllGains += added;
    }

    /**
     * Prints the statistics
     */
    public void PrintStats(){
        double gain=((double)sumOfAllGains / (double)sumOfAllBets) * 100.0d;
        long total=jacksOrBetter + twoPair + threeOfAKind + straight + flush + fullHouse + fourOfAKind + straightFlush + royalFlush + other;
        System.out.println("Hand\t\t\t\tNb");
        System.out.println("--------------------------------------");
        System.out.println("Jacks or Better\t\t\t" + jacksOrBetter);
        System.out.println("Two Pair\t\t\t" + twoPair);
        System.out.println("Three of a Kind\t\t\t" + threeOfAKind);
        System.out.println("Straight\t\t\t" + straight);
        System.out.println("Flush\t\t\t\t" + flush);
        System.out.println("Full House\t\t\t" + fullHouse);
        System.out.println("Four Of A Kind\t\t\t" + fourOfAKind);
        System.out.println("Straight Flush\t\t\t" + straightFlush);
        System.out.println("Royal Flush\t\t\t" + royalFlush);
        System.out.println("Other\t\t\t\t" + other);
        System.out.println("--------------------------------------");
        System.out.println("Total\t\t\t\t" + total);
        System.out.println("Credit\t\t\t\t" + sumOfAllGains + "(" + gain + "%)");
    }
}
