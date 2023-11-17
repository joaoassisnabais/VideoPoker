package Cards;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Initializes the deck of cards
 */
public class DeckOfCards {

    /**
     * List of cards that will form the deck
     */
    List<Card> deck = new ArrayList<>();

    /**
     * Constructor of the deck for simulation mode
     */
    public DeckOfCards(){
        Suit auxS = Suit.H;
        for(int i=0; i<4; i++) {
            if (i == 1) auxS = Suit.S;
            if (i == 2) auxS = Suit.D;
            if (i == 3) auxS = Suit.C;
            for (int j = 2; j <= 14; j++) {
                Card aux = new Card(auxS, j);
                deck.add(aux);
            }
        }
    }

    /**
     * Constructor of the deck for debug mode
     */
    public DeckOfCards(List<Card> deck){
        this.deck=deck;
    }

    /**
     * Shuffles the deck of cards
     */
    public void Shuffle(){
        Collections.shuffle(deck, new Random());
    }

    /**
     * Draws one card, removing it from the deck
     */
    public Card Draw(){
        Card out=deck.get(0);
        deck.remove(0);
        return out;
    }

    /**
     * Clears the deck of any cards
     */
    public void ClearDeck(){
        deck.clear();
    }

}