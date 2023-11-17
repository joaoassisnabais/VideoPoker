package Cards;

import java.util.*;

/**
 * Hand of the player
 */
public class Hand {

    /**
     * List of cards that make the hand
     */
    List<Card> hand;

    /**
     * Constructor of the hand
     */
    public Hand() {
        this.hand = new ArrayList<>();
    }

    /**
     * Copies the hand, so that the original hand of the player is not destroyed during processing
     * @param handToCopy hand that will be copied
     */
    public Hand(Hand handToCopy){
        this.hand = new ArrayList<>(handToCopy.hand);
    }

    /**
     * Adds a card to a specified index in the hand
     * @param newCard card to be added to the hand
     * @param cardIndex index in which the card should be added
     */
    public void PutCard(Card newCard, int cardIndex){
        hand.set(cardIndex, newCard);
    }

    /**
     * Adds a card to the hand
     * @param newCard card to be added to the hand
     */
    public void PutCard(Card newCard){
        hand.add(newCard);
    }

    /**
     * All cards of the hand are cleared
     */
    public void ClearHand(){
        hand.clear();
    }

    /**
     * Returns the card in the index position
     * @param index index of the card that should be returned
     * @return card of the specified index
     */
    public Card get(int index){
        return hand.get(index);
    }

    /**
     * Holds the cards of the boolean array and replaces the others
     * @param cardsToHold list of booleans that indicate the cards that should be kept in the hand
     * @param drawnCard cards that will replace the ones that are not kept in the hand
     */
    public void Hold(List<Boolean> cardsToHold, Card[] drawnCard){
        int dcIndex=0;
        for(int i=0; i<5; i++){
            if(!cardsToHold.get(i)){
                PutCard(drawnCard[dcIndex],i);
                dcIndex++;
            }
        }
    }

    public int getIndex (Card card){
        return hand.indexOf(card);
    }

    public void AcceptPrint(HandPrinter inkjet){
        inkjet.PrintHand(this);
    }

    public void sortAscendingOrder() {
        hand.sort(new CardComparator());
    }

    public void sortDescendingOrder(){
        hand.sort(new CardComparator());
        Collections.reverse(hand);
    }

}
