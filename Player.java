import Cards.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Implements the player's side of the game
 */
public class Player {

    /**
     * Initializes player's deck
     */
    private DeckOfCards deck;

    /**
     * Initializes player's hand
     */
    private Hand hand = new Hand();

    /**
     * Initializes player's credit
     */
    private long credits;

    /**
     * Constructor of the player
     * @param deck player's deck
     * @param initBalance player's initial credits
     */
    public Player(DeckOfCards deck, long initBalance){
        this.deck=deck;
        credits=initBalance;
    }


    /**
     * Initializes the initial credits of the player
     * @param initBalance initial credits
     */
    public Player(long initBalance){
        credits=initBalance;
    }

    /**
     * Updates the credits balance of the player
     * @param amount number of credits to add to the player's credits
     */
    public void UpdateBalance(int amount){
        credits+=amount;
    }


    /**
     * Returns the number of credits of the player
     * @return the number of credits of the player
     */
    public long getCredits(){
        return credits;
    }

    /**
     * Creates a new shuffled deck for the player
     */
    public void NewDeck(){
        if (deck!=null) {
            deck.ClearDeck();
        }
        DeckOfCards newDeck=new DeckOfCards();
        newDeck.Shuffle();
        deck=newDeck;
    }

    /**
     * Returns the hand of the player
     * @return the hand of the player
     */
    public Hand getHand(){
        return hand;
    }

    /**
     * Creates a new hand for the player
     */
    public void NewHand(){
        hand.ClearHand();
        for (int i = 0; i < 5; i++) {
            hand.PutCard(deck.Draw());
        }
    }

    /**
     * Uses a visitor to print the hand
     */
    public void PrintHand(){
        HandPrinter epson=new HandPrinter();
        hand.AcceptPrint(epson);
    }

    /**
     * Keeps the cards of the indexes that are set as true in the list
     * @param keep list of indexes for the card to keep in the hand
     */
    public void Hold(List<Boolean> keep){
        int falseCount=0;

        for (boolean i : keep) {
            if (!i) falseCount++;
        }

        //in case you don't need to switch any it shouldn't run the code
        if(falseCount!=0) {
            Card[] replacement = new Card[falseCount];

            for (int i = 0; i < falseCount; i++) {
                replacement[i] = deck.Draw();
            }
            hand.Hold(keep, replacement);
        }
    }
}
