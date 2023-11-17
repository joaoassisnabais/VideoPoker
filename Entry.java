import Cards.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Contains the main
 * <p>Reads the commands in the terminal and runs the game accordingly
 */
public class Entry {
    /**
     * List of commands
     */
    List<String> cmds = new ArrayList<>();
    /**
     * List of cards
     */
    List<Card> cards = new ArrayList<>();

    /**
     * Main function of the programm
     * <p> Checks if the game is in simulation mode or debug mode</p>
     * @param args args from the terminal
     */
    public static void main(String[] args){

        if (args.length < 4) System.out.println("Not enough arguments");
        if (args.length > 4) System.out.println("Too many arguments");
        Entry entry = new Entry();
        switch (args[0]) {
            case "-s" -> entry.RunSim(args);
            case "-d" -> entry.RunDebug(args);
            default -> {
                System.out.println("Invalid game mode");
                System.exit(0);
            }
        }
    }

    /**
     * Runs the game in debug mode
     * @param args arguments given in the command line
     */
    private void RunDebug(String[] args){
        long credit= 0L;
        //tries to convert the inputs into numbers
        try {
            credit = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("One of the input values is not an integer");
            System.exit(1);
        }
        FileReader(args);

        Game debug = new DebugGame(credit, cmds, new DeckOfCards(cards));
        debug.RunGame();
    }

    /**
     * Runs the game in simulation mode
     * @param args arguments given in the command line
     */
    private void RunSim(String[] args){
        int bet = 0;
        long credit = 0L;
        long nDeals = 0L;

        //tries to convert the inputs into numbers
        try{
            credit = Long.parseLong(args[1]);
            bet = Integer.parseInt(args[2]);
            nDeals = Long.parseLong(args[3]);
        }catch (NumberFormatException e) {
            System.out.println("One of the input values is not an integer");
            System.exit(1);
        }

        if (bet < 1 || bet > 5) {
            System.out.println("Bet must be between 1 and 5 credits");
            System.exit(1);
        }if (nDeals <= 0) {
            System.out.println("Number of deals must a positive integer");
        }

        Game sim = new SimGame(credit, bet, nDeals);
        sim.RunGame();
    }

    /**
     * Reads the file given in the command line
     * @param args files to be read
     */
    private void FileReader(String[] args){

        try {
            File cmdFile = new File(args[2]);
            File cardFile = new File(args[3]);
            Scanner cmdScan = new Scanner(cmdFile);
            Scanner cardScan = new Scanner(cardFile);
            cmdScan.useDelimiter(" ");
            cardScan.useDelimiter( " ");

            //Scans the command file and tests if commands are valid
            while(cmdScan.hasNext()){
                String aux=cmdScan.next();
                aux = aux.replace(System.getProperty("line.separator"), "");
                cmds.add(aux);
            }

            //Scans the cards file and tests if cards are valid
            while(cardScan.hasNext()){
                String aux=cardScan.next();
                aux = aux.replace(System.getProperty("line.separator"), "");
                char[] auxCh = aux.toCharArray();
                Suit cardSuit = null;
                int cardValue=0;
                //Verification of suits and conversion to Cards.Suit enum
                switch(auxCh[1]) {
                    case 'H' -> cardSuit= Suit.H;
                    case 'D' -> cardSuit=Suit.D;
                    case 'S' -> cardSuit=Suit.S;
                    case 'C' -> cardSuit=Suit.C;
                    default -> {
                        System.out.println("Card file contains unsupported character for the suit");
                        System.exit(1);
                    }
                }
                //Verification of values and conversion to integers
                switch (auxCh[0]) {
                    case '2', '3', '4', '5', '6', '7', '8', '9' -> cardValue = Character.getNumericValue(auxCh[0]);
                    case 'T' -> cardValue = 10;
                    case 'J' -> cardValue = 11;
                    case 'Q' -> cardValue = 12;
                    case 'K' -> cardValue = 13;
                    case 'A' -> cardValue = 14;
                    default -> {
                        System.out.println("Card file contains unsupported character for the value");
                        System.exit(1);
                    }
                }
                Card auxC = new Card(cardSuit, cardValue);
                cards.add(auxC);
            }
            cardScan.close();
            cmdScan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("One of the files was not found");
            System.exit(0);
        }

    }

}
