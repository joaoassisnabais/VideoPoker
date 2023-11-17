import Paytable.Payment;
import Paytable.PaymentFactory;

/**
 * Runs the game
 */
public abstract class Game {

    /**
     * Initializes the player
     */
    Player player;

    /**
     * Initializes the statistics
     */
    Statistics stats;

    /**
     * Credit to bet
     */
    int bet;

    /**
     * Constructor of the game
     */
    public abstract void RunGame();

    /**
     * Checks the combination in the player's hand and pays accordind to the bet
     * @param print If true, some information about the game are printed
     */
    void CheckAndPay(boolean print){
        Combinations comb=new Combinations(player.getHand());
        CombinationsOutput aux = comb.checkCombo(stats);
        Payment p = PaymentFactory.getPayment(aux.payTableIndex(), aux.interestCard());
        player.UpdateBalance(p.payOut(bet));
        stats.updateSum(p.payOut(bet));
        if(print) PrintHold(aux);
    }

    /**
     * Prints information about the play
     * @param aux information about the combination
     */
    void PrintHold(CombinationsOutput aux){
        player.PrintHand();
        if(aux.interestCard()==-1)
            System.out.println("PLayer loses and his credit is " + player.getCredits());
        else System.out.println("Player wins with a " + aux.Combo() + " and his credit is " + player.getCredits());
    }
}
