import Combinations.PokerRules;

import java.util.List;

/**
 * Implements the simulation game mode
 */
public class SimGame extends Game{

    /**
     * Number of deals to be played
     */
    private final long nDeals;

    /**
     * Constructor of the game
     * @param credits number of credits
     * @param bet number of credits to bet
     * @param nDeals number of deals to play
     */
    public SimGame(long credits, int bet, long nDeals){
        this.bet=bet;
        this.nDeals=nDeals;
        this.stats=new Statistics(bet*nDeals);
        player=new Player(credits);
    }

    /**
     * Runs the game in simulation mode
     * <p>Gets a new deck and hand in each deal, checks the combination and pays the player. Prints the statistics
     */
    @Override
    public void RunGame(){
        List<Boolean> adviceB;
        for (int i=0; i<nDeals ; i++) {
            //Get a new shuffled deck and hand
            player.NewDeck();
            player.NewHand();

            //Update player balance with bet
            player.UpdateBalance(-bet);

            //call advice and get return
            PokerRules advice = new PokerRules();
            adviceB=advice.Advice(player.getHand());
            player.Hold(adviceB);
            CheckAndPay(false);
        }
        //Prints out statistics
        stats.PrintStats();
    }

}
