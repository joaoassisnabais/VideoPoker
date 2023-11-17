import Cards.DeckOfCards;
import Combinations.PokerRules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implements the debug mode
 */
public class DebugGame extends Game{

    /**
     * List of debug mode commands
     */
    private final List<String> cmds;

    /**
     * Contructor of the debug game mode
     * @param credits credits of the bet
     * @param cmds command given by the file
     * @param deck deck of cards of the player
     */
    public DebugGame(long credits, List<String> cmds, DeckOfCards deck){
        this.cmds= cmds;
        this.stats=new Statistics(credits);
        player=new Player(deck, credits);
    }

    /**
     * Runs the game in debug mode, processing the commands given, updating the credits of the player and printing information about the game
     */
    @Override
    public void RunGame() {
        int lastBet=5;
        String currentCommand, lastCommand="h";

        for(int i=0; i<cmds.size(); i++) {
            currentCommand=cmds.get(i);

            switch (currentCommand) {

                case "b":
                    if (lastCommand.equals("h")) {
                        bet = 0;
                        try {
                            bet = Integer.parseInt(cmds.get(i + 1));
                            System.out.println("- b " + bet);
                        } catch (NumberFormatException |
                                 IndexOutOfBoundsException e) {     //If it is a letter->means no amount was introduced
                            bet = lastBet;
                            System.out.println("- b");
                        }

                        if (bet > 5 || bet < 1) {
                            System.out.println("b: illegal amount");
                            break;
                        }
                        System.out.println("Player has bet " + bet);
                        player.UpdateBalance(-bet);
                        lastCommand = currentCommand;
                    } else {
                        System.out.println("b: illegal command");
                    }
                    break;

                case "$":
                    System.out.println("- $");
                    System.out.println("Player's credit is " + player.getCredits());
                    break;

                case "d":
                    if (lastCommand.equals("b")) {
                        player.NewHand();
                        System.out.println("- d");
                        player.PrintHand();
                        lastCommand = currentCommand;
                    } else {
                        System.out.println("d: illegal command");
                    }
                    break;

                case "h":
                    if (lastCommand.equals("d")) {
                        if (HoldCards(i))
                            lastCommand = currentCommand;
                    } else {
                        System.out.println("h: illegal command");
                    }
                    break;

                case "a":
                    if(lastCommand.equals("d")){
                        PokerRules advice = new PokerRules();
                        List<Boolean> adviceB = advice.Advice(player.getHand());

                        System.out.println("- a");
                        System.out.print("Player should hold cards ");
                        for (int j = 0; j < adviceB.size(); j++) {
                            if(adviceB.get(j)) {
                                System.out.print(j+1 + " ");
                            }
                        }
                        System.out.println();

                    }else {
                        System.out.println("a: illegal command");
                    }
                    break;

                case "s":
                    System.out.println("- s");
                    stats.PrintStats();
                    break;

                default:
                    try {
                        Integer.parseInt(currentCommand);
                    } catch (NumberFormatException e) {
                        System.out.println("- " + currentCommand);
                        System.out.println("Not a listed command");
                    }
                    break;
            }
        }
    }

    /**
     * Holds the cards given by the command h
     * @param mainIndex index of the cards to keep in the hand
     * @return True if any card is replaced
     */
    private boolean HoldCards(int mainIndex) {
        List<Boolean> keep = new ArrayList<>(Arrays.asList(new Boolean[5])); //track if a certain card was already found
        int hold, j;
        Collections.fill(keep, false);
        System.out.print("- h ");
        for (j = 1; j <= 5; j++) {

            try {
                hold = Integer.parseInt(cmds.get(mainIndex + j));
                System.out.print(hold + " ");
                if (hold > 5 || hold < 1) {
                    System.out.println("h: illegal cards to hold");
                    return false;
                } else
                    keep.set(hold-1,true);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {     //If it is a letter->means no amount was introduced
                break;
            }
        }
        System.out.println();
        //to see if we actually need to change any card
        player.Hold(keep);
        CheckAndPay(true);
        return true;

    }
}


